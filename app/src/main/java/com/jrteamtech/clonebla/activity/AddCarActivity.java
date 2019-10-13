package com.jrteamtech.clonebla.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.fragment.CarDetailPhoneNumberFragment;

public class AddCarActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        CarDetailPhoneNumberFragment phoneNumberFragment = new CarDetailPhoneNumberFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.add_car_detail_frame, phoneNumberFragment)
                .commit();

        setToolbar();
    }

    private void setToolbar(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Your car details");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
