package com.saliev.geeksdelivery.domain.repository

import androidx.lifecycle.LiveData
import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.presentation.model.Resourse
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategory(): Flow<Resourse<BaseMainResponse<CategoryDto>?>>
}