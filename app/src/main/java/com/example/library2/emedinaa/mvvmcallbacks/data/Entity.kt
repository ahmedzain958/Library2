package com.example.library2.emedinaa.mvvmcallbacks.data

import com.example.library2.emedinaa.mvvmcallbacks.model.Museum


/**
 * @author Eduardo Medina
 */
data class MuseumResponse(val status: Int?, val msg: String?, val data: List<Museum>?) {
    fun isSuccess(): Boolean = (status == 200)
}