package com.parm.helper.ui.login;

import com.parm.helper.model.ApiResponse;
import com.parm.helper.ui.base.BasePresenter;

import java.util.List;

import rx.Observer;

/**
 * Communicate to Login Activity through LoginInterface
 * Result return by Login Webserive will be passed to Login Activity.
 *
 */
public class LoginPresenter extends BasePresenter implements Observer<List<ApiResponse>>  {

    private LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        loginInterface = loginInterface;
    }

    @Override
    public void onCompleted() {
        loginInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        loginInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<ApiResponse> loginResponses) {
        loginInterface.onLogin(loginResponses);
    }

    public void authenticateUser() {
        unSubscribeAll();
        subscribe(loginInterface.getLoginResponse(), LoginPresenter.this);
    }
}
