package com.example.library2.mvvm2.data

import com.example.library2.mvvm2.model.Museum

/**
 * @author Eduardo Medina
 */
data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}