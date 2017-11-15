package com.example.rohit.mentora;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

/**
 * Created by Rohit on 24-12-2015.
 */
public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {

    private Activity thisActivity = null;
    private ProgressDialog dialog = null;
    private String downloadUrl;
    private ImageView downloadedImg;

    public ImageDownloader(Activity thisActivity, String url, ImageView iv) {
        this.thisActivity = thisActivity;
        this.downloadUrl = url;
        this.downloadedImg = iv;
    }

    @Override
    protected Bitmap doInBackground(String... param) {
        return downloadBitmap(param[0]);
    }

    @Override
    protected void onPreExecute() {
        //dialog = new ProgressDialog(thisActivity);
        //dialog.setTitle("Please Wait!");
        //dialog.setMessage("Fetching Data From Server...");
        //dialog.show();
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        downloadedImg.setImageBitmap(result);
        dialog.dismiss();
    }

    private Bitmap downloadBitmap(String url) {
        // initilize the default HTTP client object
        final DefaultHttpClient client = new DefaultHttpClient();

        //forming a HttoGet request
        final HttpGet getRequest = new HttpGet(url);
        try {

            HttpResponse response = client.execute(getRequest);

            //check 200 OK for success
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode +
                        " while retrieving bitmap from " + url);
                return null;

            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    // getting contents from the stream
                    inputStream = entity.getContent();

                    // decoding stream data back into image Bitmap that android understands
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // You Could provide a more explicit error message for IOException
            getRequest.abort();
            Log.e("ImageDownloader", "Something went wrong while" +
                    " retrieving bitmap from " + url + e.toString());
        }
        return null;
    }
}