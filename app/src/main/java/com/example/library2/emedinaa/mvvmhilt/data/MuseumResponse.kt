package com.example.library2.emedinaa.mvvmhilt.data

import com.example.library2.emedinaa.mvvmhilt.model.Museum

data class MuseumResponse(val status:Int?,val msg:String?,val data:List<Museum>?){
    fun isSuccess():Boolean= (status==200)
}