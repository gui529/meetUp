package com.example.guc200.meet;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Created by guc200 on 5/12/2017.
 */


public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent_activity);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        Button button = (Button) findViewById(R.id.action_bar_forward);
        button.setVisibility(View.GONE);
    }

    public void closeEvent(View view){

    }


    public void pickDate(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new dateFragment()).addToBackStack(null);
        ft.commit();
    }


    public void pickTime(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new timeFragment()).addToBackStack(null);
        ft.commit();
    }

    public void confirmDate(View view){
        String dayOfWeek = "";
        TextView dateTextField;
        DatePicker datePicker;

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        dateTextField= (TextView) findViewById(R.id.dateTextField);

        Calendar cal = new GregorianCalendar(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String weekDay = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        String dayOfMonth = String.valueOf(cal.get(Calendar.DATE));
        String year = String.valueOf(cal.get(Calendar.YEAR));




        Log.d("app",month);
        Log.d("app",weekDay);
        Log.d("app",dayOfMonth);

        dateTextField.setText("Date: "+weekDay+", "+month+ " " +dayOfMonth+" of "+year);
//Date: Thursday, September 21 of 2016
        getSupportFragmentManager().popBackStack();



    }


    public void closeDatePicker(View view){
        getSupportFragmentManager().popBackStack();
    }

}



