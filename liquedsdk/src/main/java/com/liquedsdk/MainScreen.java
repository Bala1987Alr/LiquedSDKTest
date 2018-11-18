package com.liquedsdk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.liquedsdk.Security.Preferences;
import com.liquedsdk.presenter.ILoginPresenter;
import com.liquedsdk.presenter.LoginPresenter;
import com.liquedsdk.view.ILoginView;

public class MainScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Preferences preferences;
    private byte[] userByte,passByte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        sharedPreferences=getSharedPreferences(Preferences.SHARED_PREFENCE_NAME,Context.MODE_PRIVATE);

    }

    public void trigger_reg(View v)
    {

        boolean isUserRegistered=sharedPreferences.getBoolean(Preferences.IS_REGISTERED,false);
        if (isUserRegistered) {
            startActivity(new Intent(this, LoginScreen.class));
        } else {
            startActivity(new Intent(this, RegistrationScreen.class));
        }
    }

    public void payment(View v)
    {
        if(!sharedPreferences.getBoolean(Preferences.IS_REGISTERED,false)) {
            startActivity(new Intent(this, RegistrationScreen.class));
        }
        else if(!sharedPreferences.getBoolean(Preferences.IS_LOGIN,false)){
            startActivity(new Intent(this, LoginScreen.class));
        }
        else {
            startActivity(new Intent(this, HomeScreen.class));
        }
    }


}
