package com.saliev.geeksdelivery.core.base

import com.bumptech.glide.util.Util
import com.saliev.geeksdelivery.core.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Request

fun <T> makeNetWorkRequest(
    getherIsSucceed : ((T) -> Unit)? = null,
    request: suspend () -> T
) = flow<Either<String,T>>{
    request().also {
        getherIsSucceed?.invoke(it)
        emit(Either.Right(value = it))
    }
}.flowOn(Dispatchers.IO).catch { ex ->
    emit(Either.Left(value = ex.localizedMessage ?: "Error Occurred!"))
}