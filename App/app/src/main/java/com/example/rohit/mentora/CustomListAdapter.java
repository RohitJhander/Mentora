package com.example.rohit.mentora;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Person> {
    private final Activity context;

    public CustomListAdapter(Activity context, ArrayList<Person> items) {
        super(context, R.layout.mylist, items);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        Person item = getItem(position);
        /*try {
            URL url = new URL(item.pic);
            Bitmap imageVal = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(imageVal);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        // Pic="NA"
        if (item.pic == "NA") {
            imageView.setImageResource(R.drawable.ic_profile);
        } else {
            /*
            ImageDownloader picDownloader = new ImageDownloader(context, item.pic, imageView);
            picDownloader.execute(item.pic);
            */
            Picasso.with(context)
                    .load(item.pic)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_profile)
                    .into(imageView);
        }
        TextView extraTxt = (TextView) rowView.findViewById(R.id.textView1);
        txtTitle.setText(item.name);
        extraTxt.setText(item.college);
        return rowView;
    }
}