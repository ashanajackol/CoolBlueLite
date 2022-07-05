package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Products
import com.ashana.test.coolblue.lite.network.ProductService
import com.ashana.test.coolblue.lite.network.model.ProductDtoMapper
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService,
                        private val mapper: ProductDtoMapper): IProductRepository {

    override suspend fun searchProduct(query: String, page: Int): List<Products> {
        val response = productService.search(query,page).products
        return mapper.getProductList(response)
    }
}