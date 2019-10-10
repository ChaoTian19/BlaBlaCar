package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.utility.Global;
import com.jrteamtech.clonebla.R;

public class NoRideFindActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageView leftarrow;
    private Button  createbutton;
    private TextView calendardate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_ride_find);


        leftarrow = (ImageView) findViewById(R.id.leftnav);
        createbutton = (Button) findViewById(R.id.tv_createride);
        calendardate = (TextView) findViewById(R.id.calendardate);

        leftarrow.setOnClickListener(this);
        createbutton.setOnClickListener(this);

        Datetimesetting();
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.leftnav){
           finish();
        }else if(id == R.id.tv_createride){
            Intent intent = new Intent(NoRideFindActivity.this,EmailActivity.class);
            startActivity(intent);
        }

    }

    private void Datetimesetting(){
        if(Global.getSelected_time() != null){
            calendardate.setText(Global.getSelected_time());
        }
    }
}
