package com.example.library2.mvvm.data

sealed class OperationResult<out T> {
    data class Success<T>(val data: List<T>?) : OperationResult<T>()
    data class Error(val exception:Exception?) : OperationResult<Nothing>()
}