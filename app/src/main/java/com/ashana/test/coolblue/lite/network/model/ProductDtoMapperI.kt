package com.ashana.test.coolblue.lite.network.model

import com.ashana.test.coolblue.lite.domain.model.Product
import com.ashana.test.coolblue.lite.domain.model.util.IDomainMapper

class ProductDtoMapperI: IDomainMapper<ProductDTO,Product> {

    override fun mapToDomainModel(domain: ProductDTO): Product {
        return Product(
            USPs = domain.USPs?: listOf(),
            availabilityState = domain.availabilityState,
            nextDayDelivery = domain.nextDayDelivery,
            productId = domain.productId,
            productImage = domain.productImage,
            productName = domain.productName,
            salesPriceIncVat = domain.salesPriceIncVat,
            reviewCount = domain.reviewCount,
            reviewAverage = domain.reviewAverage )
    }

    override fun mapFromDomainModel(domainModel: Product): ProductDTO {
        return ProductDTO(
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

    fun getProductList(list: List<ProductDTO>): List<Product> {
        return list.map { mapToDomainModel(it) }
    }

    fun getProductNetworkEntityList(list: List<Product>): List<ProductDTO> {
        return list.map{mapFromDomainModel(it)}
    }

}