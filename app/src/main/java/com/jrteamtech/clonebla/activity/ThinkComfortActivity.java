package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class ThinkComfortActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton back_arrow_btn;
    RelativeLayout yes_btn, no_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_think_comfort);

        back_arrow_btn = findViewById(R.id.img_back_arrow);
        yes_btn = findViewById(R.id.yes_comfort_btn);
        no_btn = findViewById(R.id.no_comfort_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_arrow:
                finish();
                break;
            case R.id.yes_comfort_btn:
                String yes = "yes";
                startActivity(new Intent(ThinkComfortActivity.this, ChoosePassengerActivity.class));
                break;
            case R.id.no_comfort_btn:
                String no = "no";
                startActivity(new Intent(ThinkComfortActivity.this, ChoosePassengerActivity.class));
                break;
        }
    }
}
