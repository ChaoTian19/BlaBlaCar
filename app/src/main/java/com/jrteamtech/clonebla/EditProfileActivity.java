package com.jrteamtech.clonebla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private TextView chooseprofile ;
    private ImageView choosephoto;
    private Button  saveprofile, saveemail,savemobile;

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
                Intent intent = new Intent(EditProfileActivity.this,Chooseprofilephoto.class);
                startActivity(intent);
            }
        });


    }
}
