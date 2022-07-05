package com.ashana.test.coolblue.lite.network.model

import com.ashana.test.coolblue.lite.domain.model.Products
import com.ashana.test.coolblue.lite.domain.model.util.IDomainMapper

class ProductDtoMapper: IDomainMapper<ProductsDTO,Products> {

    override fun mapToDomainModel(domain: ProductsDTO): Products {
        return Products(
            USPs = domain.USPs?: listOf(),
            availabilityState = domain.availabilityState,
            nextDayDelivery = domain.nextDayDelivery,
            productId = domain.productId,
            productImage = domain.productImage,
            productName = domain.productName,
            reviewInformation = domain.reviewInformation,
            salesPriceIncVat = domain.salesPriceIncVat)
    }

    override fun mapFromDomainModel(domainModel: Products): ProductsDTO {
        return ProductsDTO(
            USPs = domainModel.USPs?: listOf(),
            availabilityState = domainModel.availabilityState,
            nextDayDelivery = domainModel.nextDayDelivery,
            productId = domainModel.productId,
            productImage = domainModel.productImage,
            productName = domainModel.productName,
            reviewInformation = domainModel.reviewInformation,
            salesPriceIncVat = domainModel.salesPriceIncVat)
    }

    fun getProductList(list: List<ProductsDTO>): List<Products> {
        return list.map { mapToDomainModel(it) }
    }

    fun getProductNetworkEntityList(list: List<Products>): List<ProductsDTO> {
        return list.map{mapFromDomainModel(it)}
    }

}