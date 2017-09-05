package com.parm.helper.ui.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parm.helper.MainApplication;
import com.parm.helper.R;
import com.parm.helper.model.Output;
import com.parm.helper.model.ProductCount;
import com.parm.helper.model.ProductResponse;
import com.parm.helper.model.Response;
import com.parm.helper.service.ApiClient;


import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class ProductActivity extends AppCompatActivity implements ProductContract.View {

    @Inject
    ApiClient apiClient;
    ProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ((MainApplication) getApplication()).getAppComponent().inject(this);
        productPresenter = new ProductPresenter(this);
        productPresenter.loadProducts();
    }

    @Override
    public Observable<List<ProductResponse>> getProducts() {
        return apiClient.getProducts();
    }

    @Override
    public Observable<Response> setCount(Output output) {
        return apiClient.setProductCounts(output);
    }

    @Override
    public Observable<Response> sendCategoryCount(ProductCount productCount) {
        return apiClient.sendCategoryCount(productCount);
    }
}
