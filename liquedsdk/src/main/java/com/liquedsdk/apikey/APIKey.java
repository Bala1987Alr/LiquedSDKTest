package com.liquedsdk.apikey;

import android.content.Context;

import com.liquedsdk.Payment.Payment;

public class APIKey{

    private String appSecret;
    private String apiKey;
    private Context context;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    private Payment payment;


    public APIKey(String appSecret, String apiKey)
    {
        this.appSecret=appSecret;
        this.apiKey=apiKey;
    }
    public APIKey(String appSecret, String apiKey,Context context)
    {
        this.appSecret=appSecret;
        this.apiKey=apiKey;
        this.context=context;

    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public interface PaymentInterface {

        public void onPaymentSuccess();
        public void onPaymentFailed();
        public void onPaymentCancelled();

    }
    private PaymentInterface paymentInterface;

    public void doPayment(PaymentInterface paymentInterface)
    {

        this.paymentInterface=paymentInterface;

        if(checkAPIKey(this.appSecret, this.apiKey))
        {
            paymentToMerchant();
        }else
        {
            paymentInterface.onPaymentFailed();
        }



    }

    private boolean checkAPIKey(String appSecret, String apiKey)
    {
        //validate against server that it is valid or not
        if(appSecret.equals("1") && appSecret.equals("1"))
        {
            return true;
        }
        return false;
    }

    private void paymentToMerchant()
    {

        paymentInterface.onPaymentSuccess();

    }
}
