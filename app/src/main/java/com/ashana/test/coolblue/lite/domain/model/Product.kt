package com.ashana.test.coolblue.lite.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(

    val USPs: List<String>? = listOf(),
    val availabilityState: Int? = null,
    val nextDayDelivery: Boolean? = null,
    val productId: Int? = null,
    val productImage: String? = null,
    val productName: String? = null,
    val salesPriceIncVat: Double? = null,
    val reviewCount: Int? = null,
    val reviewAverage: Float? = null
) : Parcelable