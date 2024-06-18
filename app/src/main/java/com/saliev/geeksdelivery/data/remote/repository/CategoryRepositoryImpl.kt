package com.saliev.geeksdelivery.data.remote.repository

import com.saliev.geeksdelivery.core.Either
import com.saliev.geeksdelivery.core.base.makeNetWorkRequest
import com.saliev.geeksdelivery.data.remote.apiservice.ApiService
import com.saliev.geeksdelivery.domain.model.CategoryModel
import com.saliev.geeksdelivery.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(private val api:ApiService):CategoryRepository {

    override fun getAllCategory(): Flow<Either<String, List<CategoryModel>>> =
        makeNetWorkRequest {
            api.getAllCategory().categories.map { it.toDomain() }
        }
}



