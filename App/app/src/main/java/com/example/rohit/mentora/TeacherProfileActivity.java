package com.example.rohit.mentora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TeacherProfileActivity extends ActionBarActivity {

    TextView tTeaches;
    TextView tPhone;
    TextView tAddress;
    Person p;
    String NA = "NA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        p = (Person) this.getIntent().getSerializableExtra("person");

        setTitle(p.name);

        // College =Teaches
        tTeaches = (TextView) findViewById(R.id.textView15);
        tTeaches.setText(StringUtils.defaultIfBlank(p.college, "NA"));

        // Other = Address
        tAddress = (TextView) findViewById(R.id.textView17);
        tAddress.setText(StringUtils.defaultIfBlank(p.other, "Address: NA"));

        tPhone = (TextView) findViewById(R.id.textView16);
        tPhone.setText(StringUtils.defaultIfBlank(p.phone, "Phone: NA"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher_profile, menu);
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
