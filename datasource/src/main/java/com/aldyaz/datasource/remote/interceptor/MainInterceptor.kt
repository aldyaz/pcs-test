package com.aldyaz.datasource.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class MainInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}