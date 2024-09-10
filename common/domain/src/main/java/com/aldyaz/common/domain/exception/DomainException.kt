package com.aldyaz.common.domain.exception

abstract class DomainException(
    cause: Throwable? = null
) : Exception(cause)