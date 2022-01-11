package com.example.library2.emedinaa.cleanarchi.domain

import com.example.library2.emedinaa.cleanarchi.data.MuseumRepository
import javax.inject.Inject

class GetMuseumsUseCase @Inject constructor(private val museumRepository: MuseumRepository) {
    suspend operator fun invoke() = museumRepository.fetchMuseums()
}
