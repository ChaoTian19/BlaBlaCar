package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class PublishSuccessActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ok_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_success);

        ok_btn = findViewById(R.id.ok_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok_btn:
                startActivity(new Intent(PublishSuccessActivity.this, HomeActivity.class));
                finish();
                break;
        }
    }
}
