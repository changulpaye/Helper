package com.parm.helper.ui.product;

import com.parm.helper.R;
import com.parm.helper.model.Output;
import com.parm.helper.model.ProductCount;
import com.parm.helper.model.ProductResponse;
import com.parm.helper.model.Response;
import com.parm.helper.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import rx.Observer;


/**
 * Created by sashahan on 9/4/2017.
 *
 */

class ProductPresenter extends BasePresenter {

    private final ProductContract.View view;

    ProductPresenter(ProductContract.View view) {

        this.view = view;
    }

    void loadProducts() {

        unSubscribeAll();
        subscribe(view.getProducts(), listObserver);

    }


    private Observer<List<ProductResponse>> listObserver = new Observer<List<ProductResponse>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        @Override
        public void onNext(List<ProductResponse> productResponses) {

            if (productResponses == null || productResponses.size() == 0) {
               view.showError(R.string.empty_product_response);
                return;
            }

            //sendAssignmentOneResult(productResponses);
            //sendAssignmentTwoResult(productResponses);
            //sendAssignmentThreeResult(productResponses);
            sendAssignmentFourResult(productResponses);
        }
    };



    private void sendAssignmentOneResult(List<ProductResponse> productResponses) {
        Output output = new Output();
        output.setCount(productResponses.size());
        unSubscribeAll();
        subscribe(view.setCount(output), countObserver);
    }

    private void sendAssignmentTwoResult(List<ProductResponse> productResponses) {

        Output output = new Output();
        output.setCount(getActiveProducts(productResponses).size());
        unSubscribeAll();
        subscribe(view.setCount(output), countObserver);

    }

    private void sendAssignmentThreeResult(List<ProductResponse> productResponses) {
        List<ProductResponse> activeProducts = getActiveProducts(productResponses);
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (ProductResponse response : activeProducts) {
            String key = response.getCategory();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        ProductCount productCount = new ProductCount();
        productCount.setCategoryCount(map);
        unSubscribeAll();
        subscribe(view.sendCategoryCount(productCount), countObserver);
    }

    private void sendAssignmentFourResult(List<ProductResponse> productResponses) {
        long sum = 0;
        List<ProductResponse> productResponse = getActiveProducts(productResponses);
        for (ProductResponse product : productResponse) {
            sum = sum + product.getPrice();
        }
        Output output = new Output();
        output.setTotalValue(sum);
        unSubscribeAll();
        subscribe(view.sendProductTotalValue(output), countObserver);

    }

    private Observer<Response> countObserver = new Observer<Response>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        @Override
        public void onNext(Response response) {
            System.out.println(response.getMessage());
        }
    };

    private List<ProductResponse> getActiveProducts(List<ProductResponse> productResponses) {

        Date currentDate = getCurrentDate();
        List<ProductResponse> tempProducts = new ArrayList<>();
        for (ProductResponse productResponse : productResponses) {

            Date startDate = productResponse.getStartDate();
            Date endDate = productResponse.getEndDate();

            if (startDate.compareTo(currentDate) <= 0) {

                if (endDate == null || endDate.compareTo(currentDate) >= 0) {
                    tempProducts.add(productResponse);
                }
            }
        }
        return tempProducts;
    }

    private Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


}
