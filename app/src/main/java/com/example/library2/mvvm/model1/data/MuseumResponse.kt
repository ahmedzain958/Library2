package com.example.library2.mvvm.model1.data

import com.example.library2.mvvm.model1.model.Museum

data class MuseumResponse(val status:Int?,val msg:String?,val data:List<Museum>?){
    fun isSuccess():Boolean= (status==200)
}