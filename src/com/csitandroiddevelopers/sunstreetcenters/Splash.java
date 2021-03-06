package com.csitandroiddevelopers.sunstreetcenters;

import com.csitandroiddevelopers.sunstreetcenters.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
            	SharedPreferences prefs;
            	SharedPreferences.Editor editor;
            	
            	prefs = Splash.this.getSharedPreferences("nbRepet", MODE_PRIVATE);      
            	int value = prefs.getInt("nbRepet", 0);
            	
            	if(value<1)
            	{
            		Intent mainIntent = new Intent(Splash.this,FrontPage.class);
	                startActivity(mainIntent);
	                finish();
	                
            	}
            	
            	else
            	{
            		Intent mainIntent = new Intent(Splash.this, Mainscreen.class);
	                startActivity(mainIntent);
	                finish();
            	}
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
