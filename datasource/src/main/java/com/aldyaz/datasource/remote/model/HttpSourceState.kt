package com.aldyaz.datasource.remote.model

import com.aldyaz.datasource.remote.exception.BadRequestException
import com.aldyaz.datasource.remote.exception.InternalServerException
import java.io.IOException

sealed class HttpSourceState<out T : Any> {

    data class Success<out T : Any>(
        val data: T
    ) : HttpSourceState<T>()

    data class Error(
        private val responseCode: Int?,
        private val errorMessage: String?
    ) : HttpSourceState<Nothing>() {

        val exception = when (responseCode) {
            BadRequestException.HTTP_CODE -> BadRequestException(errorMessage.orEmpty())
            InternalServerException.HTTP_CODE -> InternalServerException(errorMessage.orEmpty())
            else -> IOException(errorMessage)
        }
    }

}