package com.saliev.geeksdelivery.presentation.module

import com.saliev.geeksdelivery.domain.usecase.CategoryItemUseCase
import com.saliev.geeksdelivery.domain.usecase.CategoryUseCase
import com.saliev.geeksdelivery.presentation.ui.fragments.menu.MenuFragmentViewModel
import org.koin.dsl.module


val uiModule = module {
    single { MenuFragmentViewModel(CategoryUseCase(get()) , CategoryItemUseCase(get()))}
}