package com.ashana.test.coolblue.lite.domain.model

data class Product(

    val USPs: List<String>? = listOf(),
    val availabilityState: Int? = null,
    val nextDayDelivery: Boolean? = null,
    val productId: Int? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val salesPriceIncVat: Double? = null,
    val reviewCount: Int? = null,
    val reviewAverage: Double? = null
)