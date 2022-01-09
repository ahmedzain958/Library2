package com.example.library2.emedinaa.flow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library2.emedinaa.flow.model.MuseumDataSource

/**
 * @author : Eduardo Medina
 */
class ViewModelFactory(private val repository: MuseumDataSource):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =   MuseumViewModel(repository) as T
}