package com.parm.helper.service;

import com.parm.helper.model.ApiResponse;
import com.parm.helper.model.Output;
import com.parm.helper.model.ProductCount;
import com.parm.helper.model.ProductResponse;
import com.parm.helper.model.Response;
import com.parm.helper.model.SignupResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pchangul on 7/18/2016.
 */
public interface ApiClient {

    /**
     * TODO Write info about method
     *
     * @return
     */
    @GET("/feeds/login.json")
    Observable<List<ApiResponse>> authenticateUser();

    @GET("/feeds/signup.json")
    Observable<SignupResponse> signUpUser();

    @Headers("userId:B1tI-l_tb")
    @GET("/challenge/input")
    Observable<List<ProductResponse>> getProducts();


    @Headers("userId:B1tI-l_tb")
    @POST("/challenge/output")
    Observable<Response> setProductCounts( @Body Output output);

    @Headers("userId:B1tI-l_tb")
    @POST("/challenge/output")
    Observable<Response> sendCategoryCount(@Body ProductCount productCount);
}
