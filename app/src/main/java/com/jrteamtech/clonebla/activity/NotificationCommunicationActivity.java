package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.fragment.AccountFragment;
import com.jrteamtech.clonebla.fragment.LoginFragment;
import com.jrteamtech.clonebla.fragment.ProfileFragment;

public class NotificationCommunicationActivity extends AppCompatActivity {

    private ImageView beforebtn, pushnotificationsbtn,emailbtn,messagingtitlebtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_communication);


        beforebtn = findViewById(R.id.beforebtn);
        pushnotificationsbtn = findViewById(R.id.pushnotifications);
        emailbtn = findViewById(R.id.email);
        messagingtitlebtn = findViewById(R.id.messagingtitle);

        beforebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Intent intent = new Intent(NotificationCommunicationActivity.this,AccountFragment.class);
//               startActivity(intent);
//               finish();
                finish();
//                getSupportFragmentManager().beginTransaction()
//                        .add(android.R.id.content, new ProfileFragment()).commit();
            }
        });

        pushnotificationsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationCommunicationActivity.this,PushNotificationsActivity.class));
            }
        });

        messagingtitlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(NotificationCommunicationActivity.this,MessagingTitleActivity.class));
            }
        });

        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationCommunicationActivity.this,EmailPushnotificationActivity.class));
            }
        });



    }
}
