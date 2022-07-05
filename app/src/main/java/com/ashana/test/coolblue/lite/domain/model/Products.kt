package com.ashana.test.coolblue.lite.domain.model

data class Products(
    val USPs: List<String>? = listOf(),
    val availabilityState: Int? = null,
    val nextDayDelivery: Boolean? = null,
    val productId: Int? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val reviewInformation: ReviewInformation? = null,
    val salesPriceIncVat: Double? = null
)