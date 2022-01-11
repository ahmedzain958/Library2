package com.example.library2.emedinaa.cleanarchi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library2.emedinaa.cleanarchi.domain.GetMuseumsUseCase

/**
 * @author Eduardo Medina
 */
class ViewModelFactory(private val useCase: GetMuseumsUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MuseumViewModel(useCase) as T
    }
}