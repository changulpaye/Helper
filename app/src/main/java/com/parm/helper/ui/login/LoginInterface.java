package com.parm.helper.ui.login;

import com.parm.helper.model.ApiResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by pchangul on 7/22/2016.
 */
public interface LoginInterface {

    void onCompleted();

    void onError(String message);

    void onLogin(List<ApiResponse> flowerResponses);

    Observable<List<ApiResponse>> getLoginResponse();
}
