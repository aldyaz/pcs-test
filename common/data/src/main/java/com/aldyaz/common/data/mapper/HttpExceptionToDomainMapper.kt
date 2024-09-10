package com.aldyaz.common.data.mapper

import com.aldyaz.common.domain.exception.CloudApiException
import com.aldyaz.common.domain.exception.DomainException
import com.aldyaz.common.domain.exception.UnknownException
import com.aldyaz.datasource.remote.exception.BadRequestException
import com.aldyaz.datasource.remote.exception.HttpResponseException
import com.aldyaz.datasource.remote.exception.InternalServerException

class HttpExceptionToDomainMapper : (HttpResponseException) -> DomainException {

    override fun invoke(p1: HttpResponseException): DomainException {
        return when (p1) {
            is BadRequestException,
            is InternalServerException -> CloudApiException(p1.message)

            else -> UnknownException()
        }
    }
}