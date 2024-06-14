package com.saliev.geeksdelivery.data.remote.repository

import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.apiservice.ApiService
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.domain.repository.CategoryRepository
import com.saliev.geeksdelivery.presentation.model.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class CategoryRepositoryImpl(private val api:ApiService):CategoryRepository {

        override fun getAllCategory(): Flow<Resourse<BaseMainResponse<CategoryDto>?>> = flow{
            val data = api.getAllCategory()
            if (data.isSuccessful){
                emit(data.body())
            }
        }.flowOn(Dispatchers.IO).catch {
            emit(//)
                return@catch
        }
    }



