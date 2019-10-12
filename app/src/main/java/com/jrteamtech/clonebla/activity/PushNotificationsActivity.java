package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class PushNotificationsActivity extends AppCompatActivity {

    private ImageView backbtn;
    private ImageView yourridestick,newstick,messagestick,ratingstick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifications);

        backbtn = findViewById(R.id.beforebtn);
        yourridestick = findViewById(R.id.yourrides);
        newstick = findViewById(R.id.news);
        messagestick = findViewById(R.id.messages);
        ratingstick = findViewById(R.id.rating);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PushNotificationsActivity.this,NotificationCommunicationActivity.class));
            }
        });
    }
}
