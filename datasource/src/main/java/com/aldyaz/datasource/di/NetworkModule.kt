package com.aldyaz.datasource.di

import com.aldyaz.datasource.di.qualifier.HttpLoggingInterceptorQualifier
import com.aldyaz.datasource.di.qualifier.MainInterceptorQualifier
import com.aldyaz.datasource.di.qualifier.PlutoInterceptorQualifier
import com.aldyaz.datasource.remote.interceptor.MainInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
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
        @HttpLoggingInterceptorQualifier httpLoggingInterceptor: Interceptor,
        @PlutoInterceptorQualifier plutoInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(mainInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(plutoInterceptor)
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