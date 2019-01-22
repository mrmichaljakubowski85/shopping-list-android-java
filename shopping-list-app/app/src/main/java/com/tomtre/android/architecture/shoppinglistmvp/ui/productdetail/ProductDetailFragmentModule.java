package com.tomtre.android.architecture.shoppinglistmvp.ui.productdetail;

import com.tomtre.android.architecture.shoppinglistmvp.di.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ProductDetailFragmentModule {

    @FragmentScope
    @Provides
    static String provideProductId(ProductDetailFragment productDetailFragment) {
        return productDetailFragment.getArguments().getString(ProductDetailFragment.KEY_PRODUCT_ID);
    }

    @FragmentScope
    @Binds
    abstract ProductDetailContract.Presenter bindPresenter(ProductDetailPresenter productDetailPresenter);

}
