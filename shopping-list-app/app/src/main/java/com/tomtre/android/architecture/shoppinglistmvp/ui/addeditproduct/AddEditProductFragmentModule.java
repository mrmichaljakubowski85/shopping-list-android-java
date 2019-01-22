package com.tomtre.android.architecture.shoppinglistmvp.ui.addeditproduct;

import android.support.annotation.Nullable;

import com.tomtre.android.architecture.shoppinglistmvp.di.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static com.tomtre.android.architecture.shoppinglistmvp.util.CommonUtils.nonNull;

@Module
public abstract class AddEditProductFragmentModule {

    @FragmentScope
    @Provides
    @Nullable
    static String provideProductId(AddEditProductFragment addEditProductFragment) {
        if (nonNull(addEditProductFragment.getArguments())) {
            return addEditProductFragment.getArguments().getString(AddEditProductFragment.KEY_EDIT_PRODUCT_ID);
        }
        return null;
    }

    @FragmentScope
    @Provides
    static boolean provideStatusLoadDataFromRepository(AddEditProductFragment addEditProductFragment) {
        return addEditProductFragment.isLoadDataFromRepository();
    }

    @FragmentScope
    @Binds
    abstract AddEditProductContract.Presenter bindPresenter(AddEditProductPresenter addEditProductPresenter);

}
