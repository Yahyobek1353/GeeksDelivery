package com.saliev.geeksdelivery.domain.usecase

import androidx.lifecycle.LiveData
import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.domain.model.CategoryModel
import com.saliev.geeksdelivery.domain.repository.CategoryRepository

import kotlinx.coroutines.flow.Flow

class CategoryUseCase(private val repository: CategoryRepository) {
    operator fun invoke(): Flow<Either<String, List<CategoryModel>>> {
        return repository.getAllCategory()
    }
}