package com.example.group14_decisionbasedgame.view;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.SwitchCompat;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.musicRelated;





public class settings_screen extends Activity {

    private Button btnBack, btnUpdate, btnRestart;
    private SwitchCompat audioSwitch;


    // TODO: Need button design for Back(X) ,Update restart, and Switch design for Audio
    // TODO: Background
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;


        getWindow().setLayout((int)(width*.4),(int)(height*.7));


        audioSwitch = (SwitchCompat) findViewById(R.id.switch1);
        audioSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audioSwitch.isChecked()) {
                    musicRelated.conintro_music();
                    }else{musicRelated.pintro_music();
                    }
                }
        });
        btnBack = (Button) findViewById(R.id.btn_Pause);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); }});
        btnRestart = (Button) findViewById(R.id.btn_Restart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
                startActivity(new Intent(settings_screen.this, Intro_Screen.class));

            }
        });
        btnUpdate = (Button) findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(settings_screen.this, R.string.update,Toast.LENGTH_LONG).show();
          }
        });
    }
}