package com.parm.helper.ui.signup;

import android.util.Log;

import com.parm.helper.model.SignupResponse;
import com.parm.helper.ui.base.BasePresenter;
import com.parm.helper.utils.Constants;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;

/**
 * View Binding done using Presenter
 */

public class SignupPresenter extends BasePresenter implements Observer<SignupResponse> {

    SignUpInterface signUpInterface;

    public SignupPresenter(SignUpInterface signUpInterface) {
        this.signUpInterface = signUpInterface;
    }
    @Override
    public void onCompleted() {
            signUpInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        //http://bytes.babbel.com/en/articles/2016-03-16-retrofit2-rxjava-error-handling.html
        if (e instanceof HttpException) {
            // We had non-2XX http error
            Log.d(Constants.LOG, ((HttpException) e).code() + "");
        } else if (e instanceof IOException) {
            // A network or conversion error happened
            Log.d(Constants.LOG, "IOException : " + e.getMessage());
        } else {
            Log.d("Retrofit Error ", e.getMessage());
        }
        signUpInterface.onError(e.getMessage());
    }
    @Override
    public void onNext(SignupResponse signUpResponse) {
            signUpInterface.onSignUp(signUpResponse);
    }

    public void signUpUser() {
        unSubscribeAll();
        subscribe(signUpInterface.getSignUpResponse(), SignupPresenter.this);
    }
}
