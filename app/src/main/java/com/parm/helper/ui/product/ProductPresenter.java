package com.parm.helper.ui.product;

import com.parm.helper.model.Output;
import com.parm.helper.model.ProductResponse;
import com.parm.helper.model.Response;
import com.parm.helper.ui.base.BasePresenter;
import com.parm.helper.ui.login.LoginPresenter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import rx.Observer;


/**
 * Created by sashahan on 9/4/2017.
 */

public class ProductPresenter extends BasePresenter {

    private final ProductContract.View view;

    public ProductPresenter(ProductContract.View view) {

        this.view = view;
    }

    public void loadProducts() {

        unSubscribeAll();
        subscribe(view.getProducts(), listObserver);

    }


    Observer<List<ProductResponse>> listObserver = new Observer<List<ProductResponse>>() {
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

            if (productResponses != null && productResponses.size() != 0) {
               // sendAssignmentOneResult(productResponses);

                sendAssignmentTwoResult(productResponses);
            }
        }
    };

    Observer<Response> countObserver = new Observer<Response>() {
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


    private void sendAssignmentOneResult(List<ProductResponse> productResponses) {
        Output output = new Output();
        output.setCount(productResponses.size());
        unSubscribeAll();
        subscribe(view.setCount(output), countObserver);
    }

    private void sendAssignmentTwoResult(List<ProductResponse> productResponses) {

        Output output = new Output();
        output.setCount(getActiveProductCount(productResponses));
        unSubscribeAll();
        subscribe(view.setCount(output), countObserver);

    }


    private int getActiveProductCount(List<ProductResponse> productResponses) {

        int counter = 0;
        Date currentDate = getCurrentDate();
        for (ProductResponse productResponse : productResponses) {


            Date startDate = productResponse.getStartDate();
            Date endDate = productResponse.getEndDate();

            if (startDate.compareTo(currentDate) >= 0) {
                if (endDate == null || endDate.compareTo(currentDate) <= 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private Date convertDate(String startDate) {
        return  new Date();
    }

    private Date getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
//        System.out.println("Current time => " + calendar.getTime());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-dd-MMM", Locale.ENGLISH);
//
//
//        String formattedDate = df.format(calendar.getTime());

    }


}
