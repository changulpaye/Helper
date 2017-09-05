package com.parm.helper.ui.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.parm.helper.model.SignupResponse;
import com.parm.helper.service.ApiClient;
import com.parm.helper.ui.base.BaseActivity;
import javax.inject.Inject;

import rx.Observable;

/**
 * Created by pchangul on 7/22/2016.
 */
public class SignUpActivity extends BaseActivity implements SignUpInterface {

    @Inject ApiClient apiClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCompleted() {
        // Dismiss dialog.
    }

    @Override
    public void onError(String message) {
        // Display error message given by server
    }

    @Override
    public void onSignUp(SignupResponse signupResponse) {
        // TO DO Take action on signup.

    }

    @Override
    public Observable<SignupResponse> getSignUpResponse() {
        return apiClient.signUpUser();
    }

}
