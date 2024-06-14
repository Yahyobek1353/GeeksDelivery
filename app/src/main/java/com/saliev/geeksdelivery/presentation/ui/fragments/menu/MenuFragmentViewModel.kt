
package com.saliev.geeksdelivery.presentation.ui.fragments.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.domain.usecase.CategoryUseCase
import com.saliev.geeksdelivery.presentation.model.Resourse
import com.saliev.geeksdelivery.presentation.model.Resourse.Loading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MenuFragmentViewModel(
    private val categoryUseCase: CategoryUseCase
) : ViewModel() {

    private val _categoryState = MutableStateFlow<Resourse<BaseMainResponse<CategoryDto>?>>(Resourse.Loading())
    val categoryState get() = _categoryState.asStateFlow()

    fun getAllCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            _categoryState.value = Loading()
            categoryUseCase().collect{
            }
        }
    }
}
