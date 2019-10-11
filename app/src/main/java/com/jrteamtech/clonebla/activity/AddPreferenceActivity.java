package com.jrteamtech.clonebla.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;

import fr.ganfra.materialspinner.MaterialSpinner;

import static java.security.AccessController.getContext;

public class AddPreferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private MaterialSpinner chattines,smoking,music,pets;
    private String[] chattinesitem = {"I'm the quiet type","I talk depending on my mood","I love to chat!"};
    private String[] smokingitem = {"No smoking please","Somking is OK sometimes","Smoking doesn't bother me"};
    private String[] musicitem = {"Silence is golden","I listen to music if i fancy it","It's all about the playlist"};
    private String[] petsitem = {"No pets please","Depends on the animal","Pets welcome.Woof!"};
    private ArrayAdapter adapterchattiness,adaptersmoking,adaptermusic,adapterpets;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperference);

        this.chattines = (MaterialSpinner) findViewById(R.id.chattiness);
        this.smoking = (MaterialSpinner) findViewById(R.id.smoking);
        this.music = (MaterialSpinner) findViewById(R.id.music);
        this.pets = (MaterialSpinner) findViewById(R.id.pets);

        setAdapter();
        setToolbar();
    }
    private void setAdapter(){
        this.adapterchattiness = new ArrayAdapter<>(AddPreferenceActivity.this, android.R.layout.simple_list_item_1, this.chattinesitem);
        this.adapterchattiness.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chattines.setAdapter(this.adapterchattiness);



        this.adaptersmoking = new ArrayAdapter<>(AddPreferenceActivity.this,android.R.layout.simple_list_item_1,this.smokingitem);
        this.adaptersmoking.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smoking.setAdapter(this.adaptersmoking);

        this.adaptermusic = new ArrayAdapter<>(AddPreferenceActivity.this,android.R.layout.simple_list_item_1,this.musicitem);
        this.adaptermusic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        music.setAdapter(this.adaptermusic);

        this.adapterpets = new ArrayAdapter<>(AddPreferenceActivity.this,android.R.layout.simple_list_item_1,this.petsitem);
        this.adapterpets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pets.setAdapter(this.adapterpets);
    }



    private void setToolbar(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Edit preferences");
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

    @Override
    public void onClick(View v) {

    }
}
