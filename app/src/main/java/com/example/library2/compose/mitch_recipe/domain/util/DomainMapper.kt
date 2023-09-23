package com.example.library2.compose.mitch_recipe.domain.util

/**
 * Mitch settled down on
 * entities: form db models
 * DTOs for network models
 */
interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T

}