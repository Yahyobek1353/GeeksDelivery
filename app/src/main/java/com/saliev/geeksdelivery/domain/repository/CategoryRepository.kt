package com.saliev.geeksdelivery.domain.repository

import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategory(): Flow<Either<String , List<CategoryModel>>>
}