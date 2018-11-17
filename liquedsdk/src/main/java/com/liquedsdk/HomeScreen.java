package com.liquedsdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liquedsdk.Payment.Payment;
import com.liquedsdk.Payment.PaymentBuilder;
import com.liquedsdk.Security.Preferences;
import com.liquedsdk.apikey.APIBuilder;
import com.liquedsdk.apikey.APIKey;
import com.liquedsdk.exceptions.PaymentException;

public class HomeScreen extends AppCompatActivity {

    APIKey apiKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        apiKey=new APIBuilder()
                .setAPIKey("1")
                .setSecret("1")
                .setContext(getApplicationContext())
                .build();

    }
    public void payment(View view)
    {

        Payment payment=new PaymentBuilder()
                .setPaymentTitle("")
                .setTotalAmout(10)
                .setPayemtQty("")
                .setPaymentReferenceNumber("")
                .setMerchantId("")
                .build();
        apiKey.setPayment(payment);
        apiKey.doPayment(new APIKey.PaymentInterface() {
            @Override
            public void onPaymentSuccess() throws PaymentException {
                Toast.makeText(getApplicationContext(),"Payment Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaymentFailed() {
                Toast.makeText(getApplicationContext(),"Payment Failed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaymentCancelled() {
                Toast.makeText(getApplicationContext(),"Payment Cancelled",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void logout(View view)
    {
        SharedPreferences preferences=getSharedPreferences(Preferences.SHARED_PREFENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(Preferences.IS_LOGIN, false);
        editor.commit();
        startActivity(new Intent(this,LoginScreen.class));
        this.finish();
    }
    public void exit(View view)
    {
        SharedPreferences preferences=getSharedPreferences(Preferences.SHARED_PREFENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(Preferences.ENCRYPTED_KEY,"");
        editor.putString(Preferences.USER_NAME,"");
        editor.putString(Preferences.USER_PASSWORD,"");
        editor.putBoolean(Preferences.IS_REGISTERED, false);
        editor.putBoolean(Preferences.IS_LOGIN, false);
        editor.commit();
        this.finish();
    }
}
