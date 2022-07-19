package com.example.myapplication4mt19cs073lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    WallpaperManager wallpaperManager;
    Button set;
    Handler handler = new Handler();
    Integer loop = new Integer(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        set = (Button)findViewById(R.id.set);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 5000);
            }
        });
    }

    private Runnable runnable = new Runnable() {
        @SuppressLint("ResourceType")
        @Override
        public void run() {
            if(loop==1) {
                try {
                    wallpaperManager.setResource(R.drawable.sukuna);
                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                loop = 2;
            }

            else if (loop == 2) {
                try {
                    wallpaperManager.setResource(R.drawable.bk3);
                }

                catch (IOException e) {
                    e.printStackTrace();
                }

                loop = 1;
            }

            handler.postDelayed(runnable, 5000);
        }
    };
}