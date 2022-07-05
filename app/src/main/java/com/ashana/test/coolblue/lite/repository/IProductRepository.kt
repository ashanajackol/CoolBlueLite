package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Products

interface IProductRepository {

    suspend fun searchProduct(query: String, page: Int): List<Products>
}