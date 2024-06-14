package com.saliev.geeksdelivery.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("idCategory")
    val id:String? = null,
    @SerializedName("strCategory")
    val name:String? = null,
    @SerializedName("strCategoryThumb")
    val thumbCategory:String?= null,
    @SerializedName("strCategoryDescription")
    val categoryDesc: String? = null
)
