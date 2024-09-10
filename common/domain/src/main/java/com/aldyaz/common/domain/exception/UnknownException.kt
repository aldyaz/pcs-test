package com.aldyaz.common.domain.exception

class UnknownException(
    override val message: String = "Unknown exception!"
) : DomainException()