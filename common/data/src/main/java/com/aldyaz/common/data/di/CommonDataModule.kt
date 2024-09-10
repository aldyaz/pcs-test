package com.aldyaz.common.data.di

import com.aldyaz.common.data.mapper.HttpExceptionToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class CommonDataModule {

    @Provides
    fun provideHttpExceptionToDomainMapper(): HttpExceptionToDomainMapper =
        HttpExceptionToDomainMapper()

}