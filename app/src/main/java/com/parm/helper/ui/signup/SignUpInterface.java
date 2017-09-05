package com.parm.helper.ui.signup;

import com.parm.helper.model.SignupResponse;
import com.parm.helper.ui.base.MvpInterface;

import rx.Observable;

/**
 * Provide communication channel between View and Presenter.
 */
public interface SignUpInterface extends MvpInterface {

    void onCompleted();

    void onError(String message);

    void onSignUp(SignupResponse signUpResponse);

    Observable<SignupResponse> getSignUpResponse();
}
