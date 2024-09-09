package com.aldyaz.datasource.di

import com.aldyaz.datasource.di.qualifier.PlutoInterceptorQualifier
import com.pluto.plugins.network.okhttp.PlutoOkhttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor

@InstallIn(SingletonComponent::class)
@Module
class PlutoNetworkModule {

    @PlutoInterceptorQualifier
    @Provides
    fun providePlutoInterceptor(): Interceptor = PlutoOkhttpInterceptor

}