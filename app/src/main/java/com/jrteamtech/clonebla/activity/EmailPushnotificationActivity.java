package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class EmailPushnotificationActivity extends AppCompatActivity {

    private ImageView backbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_pushnotification);

        backbtn= findViewById(R.id.beforebtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmailPushnotificationActivity.this,NotificationCommunicationActivity.class));
            }
        });


    }
}
