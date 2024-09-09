package com.aldyaz.datasource.remote.exception

import java.io.IOException

abstract class HttpResponseException(
    val httpCode: Int,
    override val message: String
) : IOException()