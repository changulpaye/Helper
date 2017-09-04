package com.parm.helper.ui.product;

import com.parm.helper.model.Output;
import com.parm.helper.model.ProductResponse;
import com.parm.helper.model.Response;

import java.util.List;

import rx.Observable;

/**
 * Created by sashahan on 9/4/2017.
 */

public class ProductContract {

    public interface View {

        Observable<List<ProductResponse>> getProducts();

        Observable<Response> setCount(Output output);
    }
}
