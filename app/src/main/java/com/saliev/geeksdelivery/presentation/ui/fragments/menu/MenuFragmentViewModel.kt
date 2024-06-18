
package com.saliev.geeksdelivery.presentation.ui.fragments.menu

import com.saliev.geeksdelivery.core.base.BaseViewModel
import com.saliev.geeksdelivery.domain.usecase.CategoryItemUseCase
import com.saliev.geeksdelivery.domain.usecase.CategoryUseCase
import com.saliev.geeksdelivery.presentation.model.CategoryItemUI
import com.saliev.geeksdelivery.presentation.model.CategoryUI
import com.saliev.geeksdelivery.presentation.model.toUi
import kotlinx.coroutines.flow.asStateFlow

class MenuFragmentViewModel(
    private val categoryUseCase: CategoryUseCase,
    private val categoryItemUseCase: CategoryItemUseCase
) : BaseViewModel() {

    private val _categoryItemState = mutableUiStateFlow<List<CategoryItemUI>>()
    private val _categoryState = mutableUiStateFlow<List<CategoryUI>>()
    val categoryState get() = _categoryState.asStateFlow()
    val categoryItemState get() = _categoryItemState.asStateFlow()

    fun categoryItem() =
        categoryItemUseCase().gatherRequest(_categoryItemState){categoryItemModel->
            categoryItemModel.map { it.toUi() }
        }

    fun category() =
        categoryUseCase().gatherRequest(_categoryState){ categoryModel ->
            categoryModel.map { it.toUi() }
        }

}
