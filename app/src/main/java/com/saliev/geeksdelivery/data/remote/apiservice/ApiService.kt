package com.saliev.geeksdelivery.data.remote.apiservice

import com.saliev.geeksdelivery.data.base.BaseMainResponse
import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.data.remote.dto.CategoryItemDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getAllCategory(): BaseMainResponse<CategoryDto>

    @GET("filter.php")

    suspend fun getItemCategory(
        @Query("c") category: String? = null,
    ) : BaseMainResponse<CategoryItemDto>
}