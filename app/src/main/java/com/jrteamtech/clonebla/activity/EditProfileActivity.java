package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class EditProfileActivity extends AppCompatActivity {

    private TextView chooseprofile ;
    private ImageView choosephoto;
    private Button  saveprofile, saveemail,savemobile;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        chooseprofile = (TextView)findViewById(R.id.profiletxt);
        choosephoto = (ImageView)findViewById(R.id.profileimg);
        saveprofile = (Button)findViewById(R.id.save_profile);
        saveemail = (Button)findViewById(R.id.save_email);
        savemobile = (Button)findViewById(R.id.save_mobile);

        choosephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, ChooseProfilePhotoActivity.class);
                startActivity(intent);
            }
        });

        setToolbar();
    }
    private void setToolbar(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Edit profile");
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
