package com.ashana.test.coolblue.lite.di

import com.ashana.test.coolblue.lite.network.ProductService
import com.ashana.test.coolblue.lite.network.model.ProductDtoMapperI
import com.ashana.test.coolblue.lite.repository.IProductRepository
import com.ashana.test.coolblue.lite.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providerProductRepository(service: ProductService,
                                  productDtoMapper: ProductDtoMapperI): IProductRepository {
        return ProductRepository(service, productDtoMapper);
    }
}