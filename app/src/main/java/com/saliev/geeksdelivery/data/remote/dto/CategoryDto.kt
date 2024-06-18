package com.saliev.geeksdelivery.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.saliev.geeksdelivery.data.mapper.DataMapper
import com.saliev.geeksdelivery.domain.model.CategoryModel

data class CategoryDto(
    @SerializedName("idCategory")
    val id:String? = null,
    @SerializedName("strCategory")
    val name:String? = null,
    @SerializedName("strCategoryThumb")
    val thumbCategory:String?= null,
    @SerializedName("strCategoryDescription")
    val categoryDesc: String? = null
): DataMapper<CategoryModel> {

    override fun toDomain() = CategoryModel (
        id = id,
        thumbCategory = thumbCategory,
        categoryDesc = categoryDesc,
        name = name
    )
}
