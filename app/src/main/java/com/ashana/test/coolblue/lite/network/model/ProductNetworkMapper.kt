package com.ashana.test.coolblue.lite.network.model

import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.domain.model.util.EnitityMapper

class ProductNetworkMapper: EnitityMapper<ProductNetworkEntity,Product> {

    override fun mapFromEntity(entity: ProductNetworkEntity): Product {
        return Product(
            USPs = entity.USPs?: listOf(),
            availabilityState = entity.availabilityState,
            nextDayDelivery = entity.nextDayDelivery,
            productId = entity.productId,
            productImage = entity.productImage,
            productName = entity.productName,
            salesPriceIncVat = entity.salesPriceIncVat,
            reviewCount = entity.reviewCount,
            reviewAverage = entity.reviewAverage )
    }

    override fun mapToEntity(domainModel: Product): ProductNetworkEntity {
        return ProductNetworkEntity(
            USPs = domainModel.USPs?: listOf(),
            availabilityState = domainModel.availabilityState,
            nextDayDelivery = domainModel.nextDayDelivery,
            productId = domainModel.productId,
            productImage = domainModel.productImage,
            productName = domainModel.productName,
            salesPriceIncVat = domainModel.salesPriceIncVat,
            reviewCount = domainModel.reviewCount,
            reviewAverage = domainModel.reviewAverage )
    }

    fun getProductList(list: List<ProductNetworkEntity>): List<Product> {
        return list.map { mapFromEntity(it) }
    }

    fun getProductNetworkEntityList(list: List<Product>): List<ProductNetworkEntity> {
        return list.map{mapToEntity(it)}
    }

}