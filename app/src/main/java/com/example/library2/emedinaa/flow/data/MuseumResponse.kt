package com.example.library2.emedinaa.flow.data

import com.example.library2.emedinaa.flow.model.Museum

data class MuseumResponse(val status:Int?,val msg:String?,val data:List<Museum>?){
    fun isSuccess():Boolean= (status==200)
}