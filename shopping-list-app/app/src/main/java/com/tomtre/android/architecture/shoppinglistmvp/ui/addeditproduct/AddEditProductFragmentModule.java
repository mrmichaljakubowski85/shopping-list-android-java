package com.tomtre.android.architecture.shoppinglistmvp.ui.addeditproduct;

import android.support.annotation.Nullable;

import com.tomtre.android.architecture.shoppinglistmvp.data.source.repository.ProductsRepository;
import com.tomtre.android.architecture.shoppinglistmvp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AddEditProductFragmentModule {

    @Nullable
    private final String productId;
    private final boolean loadDataFromRepository;

    AddEditProductFragmentModule(@Nullable String productId, boolean loadDataFromRepository) {
        this.productId = productId;
        this.loadDataFromRepository = loadDataFromRepository;
    }

    @Provides
    @FragmentScope
    AddEditProductContract.Presenter provideAddEditProductPresenter(ProductsRepository productsRepository) {
        return new AddEditProductPresenter(productId, productsRepository, loadDataFromRepository);
    }

}
