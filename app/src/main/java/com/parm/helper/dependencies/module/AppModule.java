package com.parm.helper.dependencies.module;

import android.app.Application;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;

import com.parm.helper.dependencies.scope.CustomScope;
import com.parm.helper.service.ApiClient;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by pchangul on 7/21/2016.
 */

/**
 * We create a class called AppModule.java and annotate it with
 * @Module to signal to Dagger to search within the available methods for possible instance providers.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }


    /**
     * Retrofit is a dependency.
     * @param retrofit
     * @return
     */
    @Provides
    @CustomScope
    ApiClient provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiClient.class);
    }

    @Provides
    @CustomScope
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @CustomScope
    public LocationManager provideLocationManager(Application application) {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @CustomScope
    public BluetoothManager provideBlueToothManager(Application application) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return (BluetoothManager) application.getSystemService(Context.BLUETOOTH_SERVICE);
        }
        return null;
    }
}
