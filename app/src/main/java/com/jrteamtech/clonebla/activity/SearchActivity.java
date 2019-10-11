package com.jrteamtech.clonebla.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.jrteamtech.clonebla.R;

import java.util.Locale;

import jrizani.jrmapview.JRMapView;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    private EditText stationload;
    private ImageView leftnavbutton,zoombutton;


    private TextView uselocation;

    private GoogleMap mMap;
    private JRMapView mMapView;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_search);

        mMapView = findViewById(R.id.mapView);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 123);
        } else {

            mMapView.onCreate(savedInstanceState, this);
            mMapView.onResume();
        }

        stationload = (EditText) findViewById(R.id.where_tv_leaving_from);
        stationload.requestFocus();

        uselocation   = (TextView) findViewById(R.id.where_tv_going_to);
        leftnavbutton = (ImageView)findViewById(R.id.search_back_btn);
      //  Wheresearch  = (TextView)findViewById(R.id.where_tv_search);
         zoombutton = (ImageView)findViewById(R.id.search_icon);

        stationload.setOnClickListener(this);
        uselocation.setOnClickListener(this);
        leftnavbutton.setOnClickListener(this);
     //   Wheresearch.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
      int id = view.getId();
      if(id == R.id.search_back_btn){
           leftnavbutton.setVisibility(View.INVISIBLE);
           zoombutton.setVisibility(View.VISIBLE);
//          Intent intent = new Intent(SearchActivity.this,SearchFragment.class);
//                  startActivity(intent);
          finish();
      }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 123){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mMapView.onCreate(savedInstanceState, this);
                mMapView.onResume();
            } else {

            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setMyLocationEnabled(true);
        mMapView.onMapReady(googleMap);

        mMapView.setGoogleMapPadding(0,24,24,0);

        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Marker is Sydney"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 18.f));
                }
            }
        });

        String[] locales = Locale.getISOCountries();
        for(String countryCode : locales){
            Locale obj = new Locale("", countryCode);

            System.out.println("Country Name = " + obj.getDisplayCountry());
        }
    }
}
