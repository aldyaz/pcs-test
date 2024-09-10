package com.aldyaz.pcstest.di

import com.aldyaz.common.domain.coroutines.CoroutinesContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class CoroutinesContextModule {

    @Provides
    fun provideDefaultCoroutinesContextProvider(): CoroutinesContextProvider =
        CoroutinesContextProvider.Default

}