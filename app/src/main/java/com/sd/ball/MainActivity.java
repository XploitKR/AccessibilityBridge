package com.sd.ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());

        setAccessibility("nu.nav.bar/.service.NavigationBarService");
    }

    public void setAccessibility(String target){
        try{
            /*Settings.Secure.putString(getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES, target);
            Settings.Secure.putString(getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED, "1");*/
            Process install = Runtime.getRuntime().exec("/system/bin/settings put secure enabled_accessibility_services " + target);
            install.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}