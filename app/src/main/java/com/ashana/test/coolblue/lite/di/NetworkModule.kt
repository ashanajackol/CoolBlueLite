package com.ashana.test.coolblue.lite.di

import com.ashana.test.coolblue.lite.network.ProductService
import com.ashana.test.coolblue.lite.network.model.ProductDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideProductMapper(): ProductDtoMapper {
        return ProductDtoMapper()
    }

    @Singleton
    @Provides
    fun provideProductService(): ProductService {
        return Retrofit.Builder()
            .baseUrl("https://bdk0sta2n0.execute-api.eu-west-1.amazonaws.com/mobile-assignment/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ProductService::class.java)
    }
}