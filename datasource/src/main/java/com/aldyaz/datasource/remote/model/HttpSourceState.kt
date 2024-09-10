package com.aldyaz.datasource.remote.model

import com.aldyaz.datasource.remote.exception.BadRequestException
import com.aldyaz.datasource.remote.exception.HttpResponseException
import com.aldyaz.datasource.remote.exception.InternalServerException

sealed class HttpSourceState<out T : Any> {

    data class Success<out T : Any>(
        val data: T
    ) : HttpSourceState<T>()

    data class Error(
        private val responseCode: Int,
        private val errorMessage: String?
    ) : HttpSourceState<Nothing>() {

        private val defaultErrMessage = "HTTP error! [code: $responseCode]"
        private val message = errorMessage?.let {
            it.ifEmpty { defaultErrMessage }
        } ?: defaultErrMessage

        val exception: HttpResponseException = when (responseCode) {
            BadRequestException.HTTP_CODE -> BadRequestException(message)
            InternalServerException.HTTP_CODE -> InternalServerException(message)
            else -> HttpResponseException(
                httpCode = responseCode,
                message = message
            )
        }
    }

}