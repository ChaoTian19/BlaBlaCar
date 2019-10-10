package com.jrteamtech.clonebla;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SeleteTimeActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private static final String TIME_PATTERN = "HH:mm";
    private Calendar calendar;
    private SimpleDateFormat timeFormat;


    private String changetime = "08:00";
    private ImageView leftnav,rightnav;
    private TextView  timeimage,calendardate;
    private TextView lblDate;
    private TextView lblTime;
 //   private DateFormat dateFormat;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_select_time);

        timeimage = (TextView) findViewById(R.id.timecalculate);
        calendardate = (TextView) findViewById(R.id.calendardate);
        leftnav   = (ImageView)findViewById(R.id.leftnav);
        rightnav  = (ImageView)findViewById(R.id.rightnav);
        calendar = Calendar.getInstance();
        timeFormat = new SimpleDateFormat(TIME_PATTERN, Locale.getDefault());


        this.timeimage.setOnClickListener(this);
        this.leftnav.setOnClickListener(this);
        this.rightnav.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        int id = view.getId();
        if(id == R.id.leftnav){
//            Intent intent = new Intent(this,ChooseDateActivity.class);
//            startActivity(intent);
            finish();
        }else if(id == R.id.rightnav){

            //  changetime = timeFormat.format(calendar.getTime());
            Global.setSelected_time(changetime);
            finish();

//            calendardate.setText(timeFormat.format(calendar.getTime()));

        }else if(id == R.id.timecalculate){
            new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true){
                @Override
                public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    changetime = "" + hourOfDay + ":" + minute;
                }
            }.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        update();
    }

    private void update() {
//        lblDate.setText(dateFormat.format(calendar.getTime()));
        timeimage.setText(timeFormat.format(calendar.getTime()));
   }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
