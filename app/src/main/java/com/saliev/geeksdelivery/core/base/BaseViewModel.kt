package com.saliev.geeksdelivery.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.core.UIState
import com.saliev.geeksdelivery.core.UIState.Error
import com.saliev.geeksdelivery.domain.model.CategoryItemModel
import com.saliev.geeksdelivery.presentation.model.CategoryItemUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> mutableUiStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    protected fun <T , S> Flow<Either<String , T>>.gatherRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (data: T) -> S
    ){
        viewModelScope.launch(Dispatchers.IO){
            state.value = UIState.Loading()
            this@gatherRequest.collect{
                when (it){
                    is Either.Left -> UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mappedData(it.value))
                }
            }
        }
    }



}