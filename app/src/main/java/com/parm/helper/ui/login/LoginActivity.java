package com.parm.helper.ui.login;

import android.bluetooth.BluetoothManager;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parm.helper.R;
import com.parm.helper.model.ApiResponse;
import com.parm.helper.service.ApiClient;
import com.parm.helper.MainApplication;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    @Inject LocationManager locationManager;
    @Inject BluetoothManager bluetoothManager;
    @Inject SharedPreferences sharedPreferences;
    @Inject SharedPreferences.Editor editor;
    @Inject SQLiteDatabase sqLiteDatabase;
    @Inject ApiClient apiClient;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MainApplication)getApplication()).getAppComponent().inject(this);
        List<String> allProviders = locationManager.getAllProviders();
        Log.d("Provider : ", allProviders.toString());
        Log.d("Bluetooth : ", bluetoothManager.toString());
     /*   editor.putString("NAME", "Parmeswhar");
        editor.apply();
        String s = sharedPreferences.getString("NAME", "Param");
        Log.d("String : ", s);*/
       /* sqLiteDatabase.execSQL("Create table hello (name)");
        sqLiteDatabase.rawQuery("insert into hello values('param')",null);
        sqLiteDatabase.rawQuery("select * from hello",null);*/

        apiClient.authenticateUser().subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<ApiResponse>>() {
            @Override
            public void call(List<ApiResponse> apiResponses) {

            }
        });
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onLogin(List<ApiResponse> flowerResponses) {

    }

    @Override
    public Observable<List<ApiResponse>> getLoginResponse() {
        return null;
    }
}
