package com.ashana.test.coolblue.lite.network.model

import com.google.gson.annotations.SerializedName

class ProductDTO(

    @SerializedName("USPs")
    var USPs: List<String>? = listOf(),
    @SerializedName("availabilityState")
    var availabilityState: Int? = null,
    @SerializedName("nextDayDelivery")
    var nextDayDelivery: Boolean? = false,
    @SerializedName("productId")
    var productId: Int? = null,
    @SerializedName("productImage")
    var productImage: String? = null,
    @SerializedName("productName")
    var productName: String? = null,
    @SerializedName("salesPriceIncVat")
    var salesPriceIncVat: Double? = null,
    @SerializedName("reviewCount")
    var reviewCount: Int? = null,
    @SerializedName("reviewAverage")
    var reviewAverage: Double? = null

)