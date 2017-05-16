package com.example.guc200.meet;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * Created by guc200 on 5/12/2017.
 */


public class AddEventActivity extends AppCompatActivity {
    dateFragment frag;

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
        frag = new dateFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.your_placeholder, frag);
        ft.commit();
    }

    public void closeDatePicker(View view){
        Log.d("app","im here");
        frag.closeFrag();

    }

}



