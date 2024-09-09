package com.aldyaz.datasource.di

import com.aldyaz.datasource.member.cloud.MemberService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CloudServiceModule {

    @Singleton
    @Provides
    fun provideMemberService(
        retrofit: Retrofit
    ): MemberService = retrofit.create(MemberService::class.java)

}