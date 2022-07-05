package com.ashana.test.coolblue.lite.repository

import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.network.ProductService
import com.ashana.test.coolblue.lite.network.model.ProductDtoMapperI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService,
                        private val mapper: ProductDtoMapperI): IProductRepository {

    override suspend fun searchProduct(query: String, page: Int): List<Product> {
        val response = productService.search(query,page).products
        return mapper.getProductList(response)
    }
}