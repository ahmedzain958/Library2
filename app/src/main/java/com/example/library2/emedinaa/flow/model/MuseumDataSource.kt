package com.example.library2.emedinaa.flow.model

import com.example.library2.emedinaa.flow.model.Museum
import kotlinx.coroutines.flow.Flow

/**
 * @author : Eduardo Medina
 */
interface MuseumDataSource {
    fun retrieveMuseumsFlow():Flow<List<Museum>>
}