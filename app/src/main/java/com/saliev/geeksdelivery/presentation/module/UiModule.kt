package com.saliev.geeksdelivery.presentation.module

import com.saliev.geeksdelivery.presentation.ui.fragments.menu.MenuFragmentViewModel
import org.koin.dsl.module


val uiModule = module {
    single { MenuFragmentViewModel(get())}
}