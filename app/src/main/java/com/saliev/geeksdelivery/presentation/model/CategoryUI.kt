package com.saliev.geeksdelivery.presentation.model

import com.saliev.geeksdelivery.domain.model.CategoryModel

data class CategoryUI(
    val id:String? = null,

    val name:String? = null,
    val thumbCategory:String?= null,
    val categoryDesc: String? = null
)
fun CategoryModel.toUi() = CategoryUI(
    id = id,
    categoryDesc = categoryDesc,
    thumbCategory = thumbCategory,
    name = name
)