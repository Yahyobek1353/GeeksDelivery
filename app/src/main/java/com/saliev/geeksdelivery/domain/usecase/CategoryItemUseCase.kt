package com.saliev.geeksdelivery.domain.usecase

import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.domain.model.CategoryItemModel
import com.saliev.geeksdelivery.domain.repository.CategoryItemRepository
import kotlinx.coroutines.flow.Flow

class CategoryItemUseCase(private val repository: CategoryItemRepository) {
    operator fun invoke() : Flow<Either<String, List<CategoryItemModel>>>{
        return repository.getAllCategoryItem()
    }
}