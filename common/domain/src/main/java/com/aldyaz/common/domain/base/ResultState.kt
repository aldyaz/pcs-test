package com.aldyaz.common.domain.base

import com.aldyaz.common.domain.exception.DomainException

sealed class ResultState<out T> {

    data class Success<out T>(
        val data: T
    ) : ResultState<T>()

    data class Error(
        val exception: DomainException
    ) : ResultState<Nothing>()

}