package com.example.library2.viewbindingemedina

import com.example.library2.mvvm2.message.OperationResult
import com.example.library2.mvvm2.model.Museum
import com.example.library2.mvvm2.model.MuseumRepository


/**
 * @author Eduardo Medina
 */
class FakeMuseumRepository : MuseumRepository {

    private val mockList: MutableList<Museum> = mutableListOf()

    init {
        mockData()
    }

    private fun mockData() {
        mockList.add(
            Museum(
                0,
                "Museo Nacional de Arqueología, Antropología e Historia del Perú",
                ""
            )
        )
        mockList.add(Museum(1, "Museo de Sitio Pachacamac", ""))
        mockList.add(Museum(2, "Casa Museo José Carlos Mariátegui", ""))
    }

    override suspend fun retrieveMuseums(): OperationResult<Museum> {
        return OperationResult.Success(mockList)
    }
}