package com.example.rohit.mentora;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends UtilityActivity implements INetworkCallNotifier {

    ImageView engineeringButton;
    ImageView medicalButton;
    ImageView abroadButton;
    ImageView tutorButton;
    ImageView registerButton;
    ImageView aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        engineeringButton = (ImageView) findViewById(R.id.imageView4);
        medicalButton = (ImageView) findViewById(R.id.imageView5);
        abroadButton = (ImageView) findViewById(R.id.imageView6);
        tutorButton = (ImageView) findViewById(R.id.imageView7);
        registerButton = (ImageView) findViewById(R.id.imageView9);
        aboutButton = (ImageView) findViewById(R.id.imageView8);

        engineeringButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map<String, String> GetParameters = new HashMap<String,
                        String>();
                if
                        (NetworkManager.getInstance().isConnected(MainActivity.this)) {
                    new NetworkProgress(MainActivity.this, MainActivity.this,
                            Constants.SEARCH_ENGINEERING_URL, GetParameters)
                            .execute(StringUtils.EMPTY);
                }
            }
        });

        medicalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map<String, String> GetParameters = new HashMap<String,
                        String>();
                if
                        (NetworkManager.getInstance().isConnected(MainActivity.this)) {
                    new NetworkProgress(MainActivity.this, MainActivity.this,
                            Constants.SEARCH_MEDICAL_URL, GetParameters)
                            .execute(StringUtils.EMPTY);
                }
            }
        });

        abroadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map<String, String> GetParameters = new HashMap<String,
                        String>();
                if
                        (NetworkManager.getInstance().isConnected(MainActivity.this)) {
                    new NetworkProgress(MainActivity.this, MainActivity.this,
                            Constants.SEARCH_STUDY_ABROAD_URL, GetParameters)
                            .execute(StringUtils.EMPTY);
                }
            }
        });

        tutorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Map<String, String> GetParameters = new HashMap<String,
                        String>();
                if
                        (NetworkManager.getInstance().isConnected(MainActivity.this)) {
                    new NetworkProgress(MainActivity.this, MainActivity.this,
                            Constants.SEARCH_TUTOR_URL, GetParameters)
                            .execute(StringUtils.EMPTY);
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onSuccess(NetworkResponse response) {
        String responseJson = response.getResponse();
        Gson gson = new Gson();
        ArrayList<Person> personList = new ArrayList<Person>();
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(responseJson);
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    personList.add(gson.fromJson(jsonArray.getString(i),
                            Person.class));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("personList", personList);
        startActivity(intent);
    }

    public void onFailure() {

    }

}
