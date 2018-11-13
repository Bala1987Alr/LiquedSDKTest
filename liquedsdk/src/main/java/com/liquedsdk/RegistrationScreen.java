package com.liquedsdk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.liquedsdk.Security.Preferences;
import com.liquedsdk.presenter.IRegistrationPresenter;
import com.liquedsdk.presenter.RegistrationPresenter;
import com.liquedsdk.view.IRegistrationView;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

public class RegistrationScreen extends AppCompatActivity implements IRegistrationView, View.OnClickListener {

    private EditText editText_UserName;
    private EditText editText_Password;
    private Button btnRegister;
    private IRegistrationPresenter registrationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);

        editText_UserName = (EditText) this.findViewById(R.id.edit_username);
        editText_Password = (EditText) this.findViewById(R.id.edit_password);
        btnRegister = (Button) this.findViewById(R.id.button_register);

        btnRegister.setOnClickListener(this);
        registrationPresenter = new RegistrationPresenter(this);

    }

    @Override
    public void onClick(View view) {

        registrationPresenter.doLogin(editText_UserName.getText().toString(), editText_Password.getText().toString());
    }

    @Override
    public void onLoginResult(Boolean result, int code) throws Exception {

        if (result)
        {
            Preferences preferences=new Preferences(this);
            preferences.storeUserCredentials(editText_UserName.getText().toString(), editText_Password.getText().toString());
            startActivity(new Intent(this, LoginScreen.class));
            this.finish();
        }
        else
            Toast.makeText(this,"Invalid entry",Toast.LENGTH_SHORT).show();
    }


}
