package com.ashana.test.coolblue.lite.domain.model.util

interface IDomainMapper<T, DomainModel> {

    fun mapToDomainModel(domain: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}