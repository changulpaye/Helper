package com.parm.helper.ui.base;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by PARAM on 7/18/2016.
 */
public abstract class BasePresenter implements Presenter {

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {

    }
    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
            configureSubscription();
    }

    protected CompositeSubscription configureSubscription(){
        if(compositeSubscription == null || compositeSubscription.isUnsubscribed()) {
            compositeSubscription = new CompositeSubscription();
        }
        return compositeSubscription;
    }



    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if(compositeSubscription !=  null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }
    /**
     * Create generic observable for Rest API
     * @param observable
     * @param <F>
     */
    protected <F> void subscribe(Observable<F> observable, Observer<F> observer) {

        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscription().add(subscription);
    }
}
