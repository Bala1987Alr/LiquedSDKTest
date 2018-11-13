package com.liquedsdk.apikey;

import android.content.Context;

public class APIKey{

    private String appSecret;
    private String apiKey;
    private Context context;

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
}
