package com.liquedsdk.presenter;

import android.os.Handler;
import android.os.Looper;

import com.liquedsdk.model.IUser;
import com.liquedsdk.model.UserModel;
import com.liquedsdk.view.IRegistrationView;

public class RegistrationPresenter implements IRegistrationPresenter{

    IRegistrationView iRegistrationView;
    IUser user;
    Handler registrationHandler;

    public RegistrationPresenter(IRegistrationView iRegistrationView)
    {
        this.iRegistrationView=iRegistrationView;
        registrationHandler=new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String name, String password){

        Boolean isLoginSuccess = true;
        user=new UserModel(name, password);
        final int code = user.isValidEntry(name,password);
        if (code!=0)
            isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        registrationHandler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    try {
                        iRegistrationView.onLoginResult(result, code);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 1000);
    }





}
