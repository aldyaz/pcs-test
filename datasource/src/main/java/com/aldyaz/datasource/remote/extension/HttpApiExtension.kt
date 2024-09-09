package com.aldyaz.datasource.remote.extension

import com.aldyaz.datasource.remote.model.HttpSourceState
import retrofit2.Response

suspend fun <T : Any> apiCall(
    method: suspend () -> Response<T>
): HttpSourceState<T> {
    var responseCode: Int? = null
    try {
        val response = method.invoke()
        val body = response.body()
        return if (response.isSuccessful && body != null) {
            HttpSourceState.Success(body)
        } else {
            val errorBodyString = response.errorBody()?.string()
            responseCode = response.code()
            HttpSourceState.Error(
                responseCode = responseCode,
                errorMessage = errorBodyString
            )
        }
    } catch (err: Exception) {
        err.printStackTrace()
        return HttpSourceState.Error(
            responseCode = responseCode,
            errorMessage = err.message
        )
    }
}