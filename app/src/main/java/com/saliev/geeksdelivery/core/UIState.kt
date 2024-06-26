package com.saliev.geeksdelivery.core

sealed class UIState<T>{
    class Idle<T> : UIState<T>()
    class Success<T>(val data : T): UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val massage : T): UIState<T>()
}