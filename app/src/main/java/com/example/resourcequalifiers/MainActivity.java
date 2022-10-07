package com.example.resourcequalifiers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate Executado");
        super.onCreate(savedInstanceState);

        this.computeWindowSizeClasses();
    }

    // vou carregar o recurso através do setContentView
    private void computeWindowSizeClasses(){
        WindowMetrics metrics = WindowMetricsCalculator.getOrCreate()
                .computeCurrentWindowMetrics(this);
        float density = getResources().getDisplayMetrics().density;
        float widthDp = metrics.getBounds().width() / density;
        float heightDp = metrics.getBounds().height() / density;
        WindowSizeClass widthWindowSizeClass;
        WindowSizeClass heightWindowSizeClass;

        if (widthDp < 600f) {
            widthWindowSizeClass = WindowSizeClass.COMPACT;
        } else if (widthDp < 840f) {
            widthWindowSizeClass = WindowSizeClass.MEDIUM;
        } else {
            widthWindowSizeClass = WindowSizeClass.EXPANDED;
        }

        if (heightDp < 480f) {
            heightWindowSizeClass = WindowSizeClass.COMPACT;
        } else if (heightDp < 900f) {
            heightWindowSizeClass = WindowSizeClass.MEDIUM;
        } else {
            heightWindowSizeClass = WindowSizeClass.EXPANDED;
        }

        setLayout(widthWindowSizeClass, heightWindowSizeClass);
    }

    public void setLayout(WindowSizeClass width, WindowSizeClass height){
        // phone port
        if(width == WindowSizeClass.COMPACT){
            setContentView(R.layout.activity_main_phone_port);
        }
        // phone land
        else if(height == WindowSizeClass.COMPACT){
            setContentView(R.layout.activity_main_phone_land);
        }
        // tablet retrato
        else if(width == WindowSizeClass.MEDIUM){
            setContentView(R.layout.activity_main_tablet_port);
        }
        // tablet paisagem
        else if(width == WindowSizeClass.EXPANDED &&
                height == WindowSizeClass.MEDIUM){
            setContentView(R.layout.activity_main_tablet_land);
        }
    }

    public enum WindowSizeClass { COMPACT, MEDIUM, EXPANDED }

    @Override
    public void onDestroy(){
        System.out.println("onDestroy executado");
        super.onDestroy();
    }
}