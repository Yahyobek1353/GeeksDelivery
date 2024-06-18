package com.saliev.geeksdelivery.domain.repository

import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.domain.model.CategoryItemModel
import kotlinx.coroutines.flow.Flow

interface CategoryItemRepository {
    fun getAllCategoryItem() : Flow<Either<String , List<CategoryItemModel>>>
}