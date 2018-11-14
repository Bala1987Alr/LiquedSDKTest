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
        Toast.makeText(this,"coming",Toast.LENGTH_SHORT).show();
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
            public void onPaymentSuccess() {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaymentFailed() {
                System.out.println("Payment failed....");
            }

            @Override
            public void onPaymentCancelled() {

            }
        });
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
