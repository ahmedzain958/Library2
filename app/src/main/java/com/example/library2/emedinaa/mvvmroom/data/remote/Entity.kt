package com.example.library2.emedinaa.mvvmroom.data.remote

import com.example.library2.emedinaa.mvvmroom.model.Museum


data class MuseumResponse(val status:Int?,val msg:String?,val data:List<Museum>?){
    fun isSuccess():Boolean= (status==200)
}