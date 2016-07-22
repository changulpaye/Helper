package com.parm.helper.dependencies.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import com.parm.helper.dependencies.database.MYSQLiteOpenHelper;
import com.parm.helper.dependencies.scope.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pchangul on 7/21/2016.
 */
@Module
public class StorageModule {

    private Context context;

    public StorageModule(Context context) {
        this.context = context;
    }

    @Provides
    @CustomScope
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @CustomScope
    public SharedPreferences.Editor provideSharedPreferencesEditor() {
        return PreferenceManager.getDefaultSharedPreferences(context).edit();
    }


    @Provides
    @CustomScope
    public SQLiteDatabase provideSqLiteDatabase() {
        MYSQLiteOpenHelper mysqLiteOpenHelper = new MYSQLiteOpenHelper(context);
        return mysqLiteOpenHelper.getWritableDatabase();
    }

}
