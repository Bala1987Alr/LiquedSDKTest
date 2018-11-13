package com.liquedsdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liquedsdk.Security.Preferences;
import com.liquedsdk.apikey.APIBuilder;
import com.liquedsdk.apikey.APIKey;

public class HomeScreen extends AppCompatActivity {

    APIKey apiKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        apiKey=new APIBuilder()
                .setAPIKey("1222132")
                .setSecret("2311312")
                .setContext(getApplicationContext())
                .build();

    }
    public void payment(View view)
    {

    }
    public void logout(View view)
    {
        SharedPreferences preferences=getSharedPreferences(Preferences.SHARED_PREFENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(Preferences.IS_LOGIN, false);
        editor.commit();
        this.finish();
    }
    public void exit(View view)
    {
        SharedPreferences preferences=getSharedPreferences(Preferences.SHARED_PREFENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(Preferences.ENCRYPTED_KEY,"");
        editor.putString(Preferences.USER_NAME,"");
        editor.putString(Preferences.USER_NAME,"");
        editor.putString(Preferences.USER_PASSWORD,"");
        editor.putBoolean(Preferences.IS_REGISTERED, false);
        editor.putBoolean(Preferences.IS_LOGIN, false);
        editor.commit();
        this.finish();
    }
}
