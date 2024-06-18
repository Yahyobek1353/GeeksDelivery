package com.saliev.geeksdelivery.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saliev.geeksdelivery.data.mapper.DataMapper
import com.saliev.geeksdelivery.domain.model.CategoryItemModel

data class CategoryItemDto(
    @SerializedName("strMeal")
    val meal : String,
    @SerializedName("strMealThumb")
    val image : String,
    @SerializedName("idMeal")
    val id : String
) : DataMapper<CategoryItemModel> {

    override fun toDomain() = CategoryItemModel (
        meal = meal,
        image = image,
        id = id
    )
}
