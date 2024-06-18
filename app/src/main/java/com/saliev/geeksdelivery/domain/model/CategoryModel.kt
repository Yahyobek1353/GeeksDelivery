package com.saliev.geeksdelivery.domain.model

import com.google.gson.annotations.SerializedName

data class CategoryModel (
    val id:String? = null,
    val name:String? = null,
    val thumbCategory:String?= null,
    val categoryDesc: String? = null
)