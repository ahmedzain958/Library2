package com.example.library2.emedinaa.cleanarchi.data.remote

import com.example.library2.emedinaa.cleanarchi.domain.Museum


/**
 * @author Eduardo Medina
 */
data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}