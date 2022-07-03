package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Product
import retrofit2.http.Query

interface IProductRepository {

    suspend fun searchProduct(query: String, page: Int): List<Product>
}