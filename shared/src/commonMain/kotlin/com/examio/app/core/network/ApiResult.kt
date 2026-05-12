package com.examio.app.core.network

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class HttpError(val statusCode: Int, val message: String) : ApiResult<Nothing>
    data class NetworkError(val message: String) : ApiResult<Nothing>
}
