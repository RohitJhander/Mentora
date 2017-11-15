package com.example.rohit.mentora;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ProfileActivity extends ActionBarActivity {

    TextView tName;
    TextView tEmail;
    TextView tPhone;
    TextView tCity;
    TextView tCountry;
    TextView tIntern;
    TextView tSchool;
    TextView tCoaching;
    TextView tCollege;
    TextView tBranch;
    TextView tRank;
    TextView tIelts;
    TextView tBoard;

    Person p;
    String NA = "NA";

    ImageView iProfilePic;
    ImageView iFb;
    ImageView callImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        p = (Person) this.getIntent().getSerializableExtra("person");

        setTitle(p.name);

        tName = (TextView) findViewById(R.id.textView);
        tName.setText(StringUtils.defaultIfBlank(p.name, "Name: NA"));

        tEmail = (TextView) findViewById(R.id.textView12);
        tEmail.setText(StringUtils.defaultIfBlank(p.email, "Email: NA"));

        tPhone = (TextView) findViewById(R.id.textView13);
        tPhone.setText(StringUtils.defaultIfBlank(p.phone, "Phone: NA"));

        tCity = (TextView) findViewById(R.id.textView2);
        tCity.setText(StringUtils.defaultIfBlank(p.city, "City: NA"));

        tCountry = (TextView) findViewById(R.id.textView3);
        tCountry.setText(StringUtils.defaultIfBlank(p.country, "Country: NA"));

        tSchool = (TextView) findViewById(R.id.textView6);
        tSchool.setText("School: " + StringUtils.defaultIfBlank(p.school, NA));

        tCollege = (TextView) findViewById(R.id.textView4);
        tCollege.setText("College: " + StringUtils.defaultIfBlank(p.college, NA));

        tBranch = (TextView) findViewById(R.id.textView5);
        tBranch.setText("Branch: " + StringUtils.defaultIfBlank(p.branch, NA));

        tBoard = (TextView) findViewById(R.id.textView8);
        tBoard.setText("XII Board Marks: " + StringUtils.defaultIfNull(p.percentage, NA));

        if (p.profession.equals("Engineering") && p.country.equals("India")) {
            //other == intern
            tIntern = (TextView) findViewById(R.id.textView14);
            tIntern.setText("Internship: " + StringUtils.defaultIfBlank(p.other, NA));

            tCoaching = (TextView) findViewById(R.id.textView7);
            tCoaching.setText("Coaching: " + StringUtils.defaultIfBlank(p.coaching, NA));

            tRank = (TextView) findViewById(R.id.textView9);
            if (p.advance != "NA" && p.mains != "NA") {
                tRank.setText("JEE Advance: " + p.advance + " Mains: " + p.mains);
            } else if (p.mains != "NA") {
                tRank.setText("JEE Mains: " + p.mains);
            } else if (p.advance != "NA") {
                tRank.setText("JEE Advance: " + p.advance);
            } else {
                tRank.setText("Rank: NA");
            }

        } else if (p.profession.equals("Medical") && p.country.equals("India")) {
            // Intern == Other
            tIntern = (TextView) findViewById(R.id.textView14);
            tIntern.setText("Internship: " + StringUtils.defaultIfBlank(p.other, NA));

            tCoaching = (TextView) findViewById(R.id.textView7);
            tCoaching.setText("Coaching: " + StringUtils.defaultIfBlank(p.coaching, NA));

            tRank = (TextView) findViewById(R.id.textView9);
            tRank.setText("PMT Rank: " + StringUtils.defaultIfBlank(p.pmt, NA));

        } else if (!p.country.equals("India")) {
            //Other = Intern
            tIntern = (TextView) findViewById(R.id.textView14);
            tIntern.setText("Internship: " + StringUtils.defaultIfBlank(p.other, NA));

            tCoaching = (TextView) findViewById(R.id.textView7);
            tCoaching.setText("IELTS Coaching: " + StringUtils.defaultIfBlank(p.coaching, NA));

            // Advance = IELTS
            tIelts = (TextView) findViewById(R.id.textView9);
            tIelts.setText("IELTS Result: " + StringUtils.defaultIfBlank(p.advance, NA));
        } else {
            tIntern = (TextView) findViewById(R.id.textView14);
            tIntern.setText("Internship: NA");

            tCoaching = (TextView) findViewById(R.id.textView7);
            tCoaching.setText("Coaching: NA");

            tRank = (TextView) findViewById(R.id.textView9);
            tRank.setText("Rank: NA");
        }

        iProfilePic = (ImageView) findViewById(R.id.imageView1);
        iFb = (ImageView) findViewById(R.id.imageView2);
        callImage = (ImageView) findViewById(R.id.imageView);


        if (p.pic == "NA") {
            iProfilePic.setImageResource(R.drawable.ic_profile);
        } else {
            // Method1
            /* try {
                URL url = new URL(p.pic);
                Bitmap imageVal = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                iProfilePic.setImageBitmap(imageVal);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            // Method2
            /*
            ImageDownloader picDownloader = new ImageDownloader(ProfileActivity.this, p.pic, iProfilePic);
            picDownloader.execute(p.pic);
            */
            //Method3
            Picasso.with(this)
                    .load(p.pic)
                    .placeholder(R.drawable.ic_loading) // optional
                    .error(R.drawable.ic_profile)         // optional
                    .into(iProfilePic);
        }

        iFb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (p.fb == "NA") {
                    Toast.makeText(getApplicationContext(), "Sorry, Fb Profile not available", Toast.LENGTH_SHORT).show();
                } else {
                    Intent facebookIntent = FBLauncher.getOpenFacebookIntent(ProfileActivity.this, p.fb);
                    startActivity(facebookIntent);
                }
            }
        });

        callImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+p.phone));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}