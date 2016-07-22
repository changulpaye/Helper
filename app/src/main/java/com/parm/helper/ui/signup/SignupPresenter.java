package com.parm.helper.ui.signup;

import com.parm.helper.model.SignupResponse;
import com.parm.helper.ui.base.BasePresenter;

import rx.Observer;

/**
 * Created by pchangul on 7/22/2016.
 */
public class SignupPresenter extends BasePresenter implements Observer<SignupResponse> {

    SignUpInterface signUpInterface;

    @Override
    public void onCompleted() {
            signUpInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        signUpInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(SignupResponse signupResponse) {
            signUpInterface.onSignUp(signupResponse);
    }

    public void signUpUser() {
        unSubscribeAll();
        subscribe(signUpInterface.getSignupResponse(), SignupPresenter.this);
    }
}
