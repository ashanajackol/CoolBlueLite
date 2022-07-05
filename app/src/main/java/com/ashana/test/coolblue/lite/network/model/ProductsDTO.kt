package com.ashana.test.coolblue.lite.network.model

import com.ashana.test.coolblue.lite.domain.model.ReviewInformation
import com.google.gson.annotations.SerializedName

class ProductsDTO (

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
    @SerializedName("reviewInformation")
    var reviewInformation: ReviewInformation? = null,
    @SerializedName("salesPriceIncVat")
    var salesPriceIncVat: Double? = null

)