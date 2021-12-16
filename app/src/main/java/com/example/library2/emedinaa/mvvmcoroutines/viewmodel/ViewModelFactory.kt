package com.example.library2.emedinaa.mvvmcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library2.emedinaa.mvvmcoroutines.model.MuseumRepository

/**
 * @author Eduardo Medina
 */
class ViewModelFactory(private val repository: MuseumRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(repository) as T
    }
}