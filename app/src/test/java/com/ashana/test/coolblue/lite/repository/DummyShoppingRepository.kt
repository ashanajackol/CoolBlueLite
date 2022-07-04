package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Product

class DummyShoppingRepository: IProductRepository {

    var productList = mutableListOf<Product>()

    override suspend fun searchProduct(query: String, page: Int): List<Product> {
        return productList
    }


}