package com.tomtre.android.architecture.shoppinglistmvp.ui.productdetail;

import android.support.annotation.Nullable;

import com.tomtre.android.architecture.shoppinglistmvp.data.source.repository.ProductsRepository;
import com.tomtre.android.architecture.shoppinglistmvp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductDetailFragmentModule {

    @Nullable
    private final String productId;

    ProductDetailFragmentModule(@Nullable String productId) {
        this.productId = productId;
    }

    @Provides
    @FragmentScope
    ProductDetailContract.Presenter provideProductDetailPresenter(ProductsRepository productsRepository) {
        return new ProductDetailPresenter(productId, productsRepository);
    }


}
