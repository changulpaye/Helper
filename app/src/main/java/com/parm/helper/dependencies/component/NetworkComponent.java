package com.parm.helper.dependencies.component;

import com.parm.helper.dependencies.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by pchangul on 7/22/2016.
 */
@Component (modules = NetworkModule.class)
@Singleton
public interface NetworkComponent  {

  Retrofit retrofit();
}
