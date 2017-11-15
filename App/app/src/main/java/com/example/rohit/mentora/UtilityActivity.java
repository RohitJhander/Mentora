package com.example.rohit.mentora;

/**
 * Created by Rohit on 18-12-2015.
 */

import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;

public class UtilityActivity extends Activity {

    protected void showAlertDialogBox(final String dialogBoxMessag,
                                      final String buttonMessage, final String button2Message,
                                      final DialogInterface.OnClickListener button1OnClickListener,
                                      final DialogInterface.OnClickListener button2OnClickListener,
                                      final boolean isCancelable) {
        final Activity thisActivity = this;
        Handler mainHandler = new Handler(thisActivity.getMainLooper());
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        thisActivity);
                builder.setMessage(dialogBoxMessag)
                        .setCancelable(isCancelable)
                        .setPositiveButton(buttonMessage,
                                button1OnClickListener);
                if (button2Message != null) {
                    builder.setNegativeButton(button2Message,
                            button2OnClickListener);
                }
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
        mainHandler.post(runnable);
    }

    protected class NetworkProgress extends AsyncTask<String, Void, Void> {

        private Activity thisActivity = null;
        private ProgressDialog dialog = null;
        private INetworkCallNotifier notifier = null;
        private String baseUrl = null;
        private Map<String, String> GetParameters = null;

        public NetworkProgress(Activity thisActivity,
                               INetworkCallNotifier notifier, String url,
                               Map<String, String> GetParameters) {
            this.thisActivity = thisActivity;
            this.baseUrl = url;
            this.notifier = notifier;
            this.GetParameters = GetParameters;
        }

        private NetworkProgress() {
        }

        protected void onPreExecute() {
            dialog = new ProgressDialog(thisActivity);
            dialog.setTitle("Please Wait!");
            dialog.setMessage("Fetching Data...");
            dialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            NetworkManager.getInstance().makeSyncNetworkCall(thisActivity,
                    notifier, baseUrl, GetParameters);
            return null;
        }

        protected void onPostExecute(Void unused) {
            dialog.dismiss();
        }
    }
}
