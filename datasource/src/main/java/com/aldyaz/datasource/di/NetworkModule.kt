package com.aldyaz.datasource.di

import com.aldyaz.datasource.di.qualifier.HttpLoggingInterceptorQualifier
import com.aldyaz.datasource.di.qualifier.MainInterceptorQualifier
import com.aldyaz.datasource.remote.interceptor.MainInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideGson(): Gson = Gson()

    @MainInterceptorQualifier
    @Provides
    fun provideMainInterceptor(): Interceptor = MainInterceptor()

    @HttpLoggingInterceptorQualifier
    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @MainInterceptorQualifier mainInterceptor: Interceptor,
        @HttpLoggingInterceptorQualifier httpLoggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(mainInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://66b197c51ca8ad33d4f482c9.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

}