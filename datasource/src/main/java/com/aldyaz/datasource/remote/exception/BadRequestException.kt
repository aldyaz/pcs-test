package com.aldyaz.datasource.remote.exception

class BadRequestException(
    override val message: String
) : HttpResponseException(
    httpCode = HTTP_CODE,
    message = message
) {

    companion object {
        const val HTTP_CODE = 400
    }
}