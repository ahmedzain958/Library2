package com.example.library2.mvvm.data

interface OperationCallback<in T> {
    fun onSuccess(data: List<T>?)
    fun onError(error: String?)
}
