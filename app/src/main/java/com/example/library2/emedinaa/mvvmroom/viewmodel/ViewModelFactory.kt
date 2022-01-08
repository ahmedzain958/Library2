package com.example.library2.emedinaa.mvvmroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library2.emedinaa.mvvmroom.model.MuseumRepository

class ViewModelFactory(private val museumRepository: MuseumRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(museumRepository) as T
    }
}