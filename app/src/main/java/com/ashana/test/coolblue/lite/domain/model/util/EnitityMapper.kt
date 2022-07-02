package com.ashana.test.coolblue.lite.domain.model.util

interface EnitityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}