package com.parm.helper.ui.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by sashahan on 9/6/2017.
 */
public class ProductPresenterTest {

    private ProductPresenter mProductPresenter;
    private ProductContract.View mView;

    @Before
    public void setUp() throws Exception {
        mView = Mockito.mock(ProductContract.View.class);
        mProductPresenter = Mockito.mock(ProductPresenter.class);
    }

    @After
    public void tearDown() throws Exception {
        mView = null;
        mProductPresenter = null;
    }

    @Test
    public void whenProductsAvailable() throws Exception {
        mProductPresenter.loadProducts();
        //Mockito.verify(mProductPresenter).sendAssignmentFourResult();

    }

}