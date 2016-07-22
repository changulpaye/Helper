package com.parm.helper;

import android.app.Application;

import com.parm.helper.dependencies.component.AppComponent;
import com.parm.helper.dependencies.component.DaggerAppComponent;
import com.parm.helper.dependencies.component.DaggerNetworkComponent;
import com.parm.helper.dependencies.component.NetworkComponent;
import com.parm.helper.dependencies.module.AppModule;
import com.parm.helper.dependencies.module.NetworkModule;
import com.parm.helper.dependencies.module.StorageModule;

/**
 * Created by pchangul on 7/21/2016.
 */
public class MainApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .storageModule(new StorageModule(this))
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
