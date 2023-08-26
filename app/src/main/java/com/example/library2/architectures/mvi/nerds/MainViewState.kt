package com.example.library2.architectures.mvi.nerds

sealed class MainViewState{
    object Idle: MainViewState()
    data class AddNumber(val number: Int): MainViewState()
    data class Error(val error: String): MainViewState()
}
