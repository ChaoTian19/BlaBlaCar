package com.jrteamtech.clonebla.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText stationload;
    private ImageView leftnavbutton,zoombutton;


    private TextView uselocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        stationload = (EditText) findViewById(R.id.where_tv_leaving_from);
        stationload.requestFocus();

        uselocation   = (TextView) findViewById(R.id.where_tv_going_to);
        leftnavbutton = (ImageView)findViewById(R.id.leftnavbutton);
      //  Wheresearch  = (TextView)findViewById(R.id.where_tv_search);
         zoombutton = (ImageView)findViewById(R.id.zoombutton);

        stationload.setOnClickListener(this);
        uselocation.setOnClickListener(this);
        leftnavbutton.setOnClickListener(this);
     //   Wheresearch.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
      int id = view.getId();
      if(id == R.id.leftnavbutton){
           leftnavbutton.setVisibility(View.INVISIBLE);
           zoombutton.setVisibility(View.VISIBLE);
//          Intent intent = new Intent(SearchActivity.this,SearchFragment.class);
//                  startActivity(intent);
          finish();
      }
    }
}
