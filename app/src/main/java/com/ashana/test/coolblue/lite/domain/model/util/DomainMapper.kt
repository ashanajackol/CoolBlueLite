package com.ashana.test.coolblue.lite.domain.model.util

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(domain: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}