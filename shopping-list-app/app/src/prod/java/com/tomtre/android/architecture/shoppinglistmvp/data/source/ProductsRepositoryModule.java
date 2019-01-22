package com.tomtre.android.architecture.shoppinglistmvp.data.source;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.tomtre.android.architecture.shoppinglistmvp.data.source.local.ProductsDao;
import com.tomtre.android.architecture.shoppinglistmvp.data.source.local.ProductsDatabase;
import com.tomtre.android.architecture.shoppinglistmvp.data.source.local.ProductsLocalDataSource;
import com.tomtre.android.architecture.shoppinglistmvp.data.source.remote.ProductsRemoteDataSource;
import com.tomtre.android.architecture.shoppinglistmvp.data.source.repository.ProductsRepository;
import com.tomtre.android.architecture.shoppinglistmvp.data.source.repository.ProductsRepositoryImpl;
import com.tomtre.android.architecture.shoppinglistmvp.di.AppScope;
import com.tomtre.android.architecture.shoppinglistmvp.di.LocalQualifier;
import com.tomtre.android.architecture.shoppinglistmvp.di.RemoteQualifier;
import com.tomtre.android.architecture.shoppinglistmvp.util.AppExecutors;

import java.util.concurrent.Executors;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ProductsRepositoryModule {
    @AppScope
    @Provides
    static ProductsDatabase provideProductsDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                ProductsDatabase.class, "Products.db")
                .build();
    }

    @AppScope
    @Provides
    static ProductsDao provideProductsDao(ProductsDatabase productsDatabase) {
        return productsDatabase.productsDao();
    }

    @AppScope
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors(Executors.newSingleThreadExecutor(), new AppExecutors.MainThreadExecutor());
    }

    @AppScope
    @Binds
    abstract ProductsRepository bindsProductsRepository(ProductsRepositoryImpl productsRepositoryImpl);

    @AppScope
    @Binds
    @LocalQualifier
    abstract ProductsDataSource bindsProductsLocalDataSource(ProductsLocalDataSource productsLocalDataSource);

    @AppScope
    @Binds
    @RemoteQualifier
    abstract ProductsDataSource bindsProductsRemoteDataSource(ProductsRemoteDataSource productsRemoteDataSource);
}