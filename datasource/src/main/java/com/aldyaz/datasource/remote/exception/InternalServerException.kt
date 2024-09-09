package com.aldyaz.datasource.remote.exception

class InternalServerException(
    override val message: String
) : HttpResponseException(
    httpCode = HTTP_CODE,
    message = message
) {

    companion object {
        const val HTTP_CODE = 500
    }
}