package com.saliev.geeksdelivery.data.mapper

interface DataMapper<T> {
    fun toDomain() : T
}