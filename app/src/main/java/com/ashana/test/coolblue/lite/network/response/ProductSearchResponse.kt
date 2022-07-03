package com.ashana.test.coolblue.lite.network.response

import com.ashana.test.coolblue.lite.network.model.ProductDTO
import com.google.gson.annotations.SerializedName

data class ProductSearchResponse (
    @SerializedName("products")
    var products: List<ProductDTO>
    )