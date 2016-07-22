package com.parm.helper.service;

import com.parm.helper.model.ApiResponse;
import com.parm.helper.model.SignupResponse;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by pchangul on 7/18/2016.
 */
public interface ApiClient {

    /**
     * TODO Write info about method
     * @return
     */
    @GET("/feeds/login.json")
    Observable<List<ApiResponse>> authenticateUser();

    @GET("/feeds/signup.json")
    Observable<SignupResponse> signUpUser();
}
