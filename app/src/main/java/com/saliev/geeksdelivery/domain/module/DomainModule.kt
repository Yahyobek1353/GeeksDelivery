package com.saliev.geeksdelivery.domain.module

import com.saliev.geeksdelivery.domain.usecase.CategoryUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { CategoryUseCase(get()) }
}