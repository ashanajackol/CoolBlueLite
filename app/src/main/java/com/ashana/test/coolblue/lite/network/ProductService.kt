package com.ashana.test.coolblue.lite.network

import com.ashana.test.coolblue.lite.network.response.ProductSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProductService {

    @GET("search")
    suspend fun search(
        @Query("query") query: String,
        @Query("page") page: Int
    ): ProductSearchResponse

}