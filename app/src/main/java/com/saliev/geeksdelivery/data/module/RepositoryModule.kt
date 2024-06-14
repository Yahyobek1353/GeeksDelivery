package com.saliev.geeksdelivery.data.module

import com.saliev.geeksdelivery.data.remote.repository.CategoryRepositoryImpl
import com.saliev.geeksdelivery.domain.repository.CategoryRepository
import org.koin.dsl.module

val repoModule = module {
    single<CategoryRepository>{ CategoryRepositoryImpl(get()) }
}