package com.saliev.geeksdelivery.domain.usecase

import androidx.lifecycle.LiveData
import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.domain.repository.CategoryRepository
import com.saliev.geeksdelivery.presentation.model.Resourse
import kotlinx.coroutines.flow.Flow

class CategoryUseCase(private val repository: CategoryRepository) {
    operator fun invoke(): Flow<Resourse<BaseMainResponse<CategoryDto>?>> {
        return repository.getAllCategory()
    }
}