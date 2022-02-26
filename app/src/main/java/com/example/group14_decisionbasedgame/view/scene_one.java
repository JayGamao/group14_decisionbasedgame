package com.example.group14_decisionbasedgame.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.dialogueFlow;

public class scene_one extends AppCompatActivity {
//TODO: UI + clock
//TODO: use switch for buttons for cleaner code

    private Button btnBack, btnAuto, btnPause;
    private Boolean allowedback = false;
    ImageView background, img_char;
    TextView txt_dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_one);
        enableFullscreen();
        new dialogueFlow();

        btnBack = (Button) findViewById(R.id.btn_Pause);
        btnAuto = findViewById(R.id.btn_auto);

        txt_dlg = findViewById(R.id.txt_dlg);

        background = findViewById(R.id.bg_image);
        img_char = findViewById(R.id.img_char);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(new Intent(scene_one.this, pause_screen.class)); }});

        dialogueFlow.sceneone(img_char,txt_dlg, btnAuto);
    }


    @Override
    public void onBackPressed() {
        if (allowedback) { super.onBackPressed(); }
        else { startActivity(new Intent(this, pause_screen.class)); } }

    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}
