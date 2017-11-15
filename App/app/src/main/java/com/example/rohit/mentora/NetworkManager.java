package com.example.rohit.mentora;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

/**
 * Created by Rohit on 18-12-2015.
 */
public class NetworkManager {

    private static final NetworkManager INSTANCE = new NetworkManager();
    private Handler mainHandler = null;
    private Runnable runnable = null;

    public static NetworkManager getInstance() {
        return INSTANCE;
    }

    private NetworkManager() {
    }

    public boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo[] info = manager.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void makeNetworkCall(Context mContext,
                                 final INetworkCallNotifier notifier, String url,
                                 Map<String, String> GetParameters) {
        try {
            boolean firstTime = true;
            for (String key : GetParameters.keySet()) {
                if (firstTime) {
                    url += "?" + key + "=" + GetParameters.get(key);
                    firstTime = false;
                } else {
                    url += "&" + key + "=" + GetParameters.get(key);
                }
            }
            URL Url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) Url.openConnection();
            final String stream = readStream(con.getInputStream());
            final int responseCode = con.getResponseCode();
            if (notifier != null) {
                mainHandler = new Handler(mContext.getMainLooper());
                runnable = new Runnable() {

                    @Override
                    public void run() {
                        NetworkResponse response = new NetworkResponse();
                        response.setResponse(stream);
                        response.setResponseCode(responseCode);
                        notifier.onSuccess(response);
                    }
                };
                mainHandler.post(runnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (notifier != null) {
                mainHandler = new Handler(mContext.getMainLooper());
                runnable = new Runnable() {

                    @Override
                    public void run() {
                        notifier.onFailure();
                    }
                };
                mainHandler.post(runnable);
            }
        }
    }

    public void makeSyncNetworkCall(Context mContext,
                                    INetworkCallNotifier notifier, String url,
                                    final Map<String, String> GetParameters) {
        makeNetworkCall(mContext, notifier, url, GetParameters);
    }

    public void makeAsyncNetworkCall(final Context mContext,
                                     final INetworkCallNotifier notifier, final String url,
                                     final Map<String, String> GetParameters) {
        Thread thread = new Thread() {
            public void run() {
                makeNetworkCall(mContext, notifier, url, GetParameters);
            }
        };
        thread.start();
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder strBuilder = new StringBuilder("");
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                strBuilder.append(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return strBuilder.toString();
    }

}
