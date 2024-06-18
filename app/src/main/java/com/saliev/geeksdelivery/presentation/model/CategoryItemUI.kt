package com.saliev.geeksdelivery.presentation.model

import com.google.gson.annotations.SerializedName
import com.saliev.geeksdelivery.domain.model.CategoryItemModel

data class CategoryItemUI(
    val meal : String,
    val image : String,
    val id : String
)

fun CategoryItemModel.toUi() = CategoryItemUI(
    meal = meal,
    image = image,
    id = id
)
