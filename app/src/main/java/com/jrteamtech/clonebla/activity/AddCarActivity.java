package com.jrteamtech.clonebla.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.database.model.CarInfo;
import com.jrteamtech.clonebla.fragment.CarDetailPhoneNumberFragment;

public class AddCarActivity extends AppCompatActivity {

    private CarInfo carInfo;
    private String edit_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        if(getIntent() != null && getIntent().getSerializableExtra("car_info") != null){
            carInfo = (CarInfo) getIntent().getSerializableExtra("car_info");
            edit_flag = getIntent().getStringExtra("edit_flag");
        } else {
            carInfo = new CarInfo();
            edit_flag = getIntent().getStringExtra("edit_flag");
        }

        CarDetailPhoneNumberFragment phoneNumberFragment = new CarDetailPhoneNumberFragment();
        Bundle b = new Bundle();
        b.putSerializable("car_info", carInfo);
        b.putString("edit_flag", edit_flag);
        phoneNumberFragment.setArguments(b);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.add_car_detail_frame, phoneNumberFragment)
                .commit();

    }
}
