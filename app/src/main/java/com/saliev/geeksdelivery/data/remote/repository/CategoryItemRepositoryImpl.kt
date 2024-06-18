package com.saliev.geeksdelivery.data.remote.repository

import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.core.base.makeNetWorkRequest
import com.saliev.geeksdelivery.data.remote.apiservice.ApiService
import com.saliev.geeksdelivery.domain.model.CategoryItemModel
import com.saliev.geeksdelivery.domain.repository.CategoryItemRepository
import com.saliev.geeksdelivery.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryItemRepositoryImpl(private val apiService: ApiService) : CategoryItemRepository {

    override fun getAllCategoryItem(): Flow<Either<String, List<CategoryItemModel>>> =
        makeNetWorkRequest {
            apiService.getItemCategory().categoriesItem.map { it.toDomain() }
        }
    }