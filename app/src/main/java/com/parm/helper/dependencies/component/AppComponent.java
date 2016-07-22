package com.parm.helper.dependencies.component;

import com.parm.helper.ui.login.LoginActivity;
import com.parm.helper.dependencies.module.AppModule;
import com.parm.helper.dependencies.module.StorageModule;
import com.parm.helper.dependencies.scope.CustomScope;

import dagger.Component;

/**
 * Created by pchangul on 7/21/2016.
 */
@CustomScope
@Component (modules = { AppModule.class, StorageModule.class}, dependencies = NetworkComponent.class)
public interface AppComponent {
    void inject(LoginActivity loginActivity);
}
