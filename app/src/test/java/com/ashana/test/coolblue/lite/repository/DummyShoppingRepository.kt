package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Products

class DummyShoppingRepository: IProductRepository {

    var productList = mutableListOf<Products>()

    override suspend fun searchProduct(query: String, page: Int): List<Products> {
        return productList
    }
}