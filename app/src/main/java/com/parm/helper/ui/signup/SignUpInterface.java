package com.parm.helper.ui.signup;

import com.parm.helper.model.SignupResponse;
import com.parm.helper.ui.base.MvpInterface;

import rx.Observable;

/**
 * Created by pchangul on 7/22/2016.
 */
public interface SignUpInterface extends MvpInterface {


    void onCompleted();

    void onError(String message);

    void onSignUp(SignupResponse signupResponse);

    Observable<SignupResponse> getSignupResponse();
}
