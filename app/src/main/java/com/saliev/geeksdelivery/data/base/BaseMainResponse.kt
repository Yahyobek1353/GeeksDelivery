package com.saliev.geeksdelivery.data.base

import com.saliev.geeksdelivery.data.remote.dto.CategoryDto
import com.saliev.geeksdelivery.data.remote.dto.CategoryItemDto

class BaseMainResponse<T>(
    val categories: List<CategoryDto>,
    val categoriesItem: List<CategoryItemDto>
)
