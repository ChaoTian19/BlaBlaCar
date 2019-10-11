package com.jrteamtech.clonebla.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

public class HelpActivity extends AppCompatActivity {

    private Toolbar toolbar;

    TextView howtoworks,faq,insurance,contacusus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        howtoworks = findViewById(R.id.howitwokrs);
        faq = findViewById(R.id.faq);
        insurance = findViewById(R.id.insurance);
        contacusus = findViewById(R.id.contactus);

        setToolbar();
    }

    private void setToolbar(){
        this.toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Help");
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
