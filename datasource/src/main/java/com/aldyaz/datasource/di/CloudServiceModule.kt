package com.aldyaz.datasource.di

import com.aldyaz.datasource.member.cloud.MemberService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CloudServiceModule {

    @Singleton
    @Provides
    fun provideMemberService(
        retrofit: Retrofit
    ): MemberService = retrofit.create(MemberService::class.java)

}