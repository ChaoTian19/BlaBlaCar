package com.jrteamtech.clonebla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.fragment.VerifyMobileFragment;

import fr.ganfra.materialspinner.MaterialSpinner;

public class VerifyPhoneNumberActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Button verifybtn;

    private MaterialSpinner regionnumber;

    private ArrayAdapter adapterregion;

    private String[] regionnumberitem = {"Ascension lsland (+247)","United Arab Emirates (+971)","Afghanistan (+93)","Antigua And Barbuda (+1)","Anguilla (+1)","Angola(+244)","American Samoa (+1)","Aruba (+297)","Aland lslands (+358)","Azerbaijan (+994)",
                                         "Algerie (+213)","Andorra (+376)","Argentina (+54)","Australia (+61)","Barbados (+1)","Bangladesh (+880)","Burkina Faso(+226)","Bahrain (+973)","Burundi (+257)","Benin (+229)","Bermuda (+1)","Brunei (+673)","Bolivia (+591)",
                                         "Caribbean Netherlands (+559)","Bahamas (+1)","Bhutan (+975)","Bo9tswana (+267)","Belize (+375)","Belgique(+32)","Bosnia / Herzegovina (+387)","Brasil (+55)","Bulgaria (359)","Cocos (keepling lslands (+61))"
                                         };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phonenumber);

        this.regionnumber = (MaterialSpinner)findViewById(R.id.regionchoose);
        verifybtn = (Button)findViewById(R.id.phoneverify);


        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(VerifyPhoneNumberActivity.this, VerifyMobileFragment.class);
              startActivity(intent);

            }
        });


        setadapter();
        setuptoolbar();
    }
    private void setadapter(){
        this.adapterregion = new ArrayAdapter<>(VerifyPhoneNumberActivity.this, android.R.layout.simple_list_item_1, this.regionnumberitem);
        this.adapterregion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regionnumber.setAdapter(this.adapterregion);
    }







    private void setuptoolbar(){
            this.toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(this.toolbar);
            getSupportActionBar().setTitle("Verify phone number");
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

