package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.fragment.DetailFragment;

public class SeePublicProfileActivity  extends AppCompatActivity {

    private ImageButton profileclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_public_profile);

        profileclose = (ImageButton) findViewById(R.id.profileclose);


        profileclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SeePublicProfileActivity.this, DetailFragment.class);
//                startActivity(intent);
                finish();
            }
        });
    }

}
