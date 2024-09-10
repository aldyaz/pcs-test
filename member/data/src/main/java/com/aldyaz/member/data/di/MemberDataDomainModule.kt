package com.aldyaz.member.data.di

import com.aldyaz.common.data.mapper.HttpExceptionToDomainMapper
import com.aldyaz.datasource.member.source.MemberCloudDataSource
import com.aldyaz.member.data.mapper.MemberToDomainMapper
import com.aldyaz.member.data.repository.MemberRepositoryImpl
import com.aldyaz.member.domain.interactor.GetMemberListUseCase
import com.aldyaz.member.domain.repository.MemberRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class MemberDataDomainModule {

    @Provides
    fun provideMemberToDomainMapper(): MemberToDomainMapper = MemberToDomainMapper()

    @Provides
    fun provideMemberRepository(
        memberCloudDataSource: MemberCloudDataSource,
        memberToDomainMapper: MemberToDomainMapper,
        httpExceptionToDomainMapper: HttpExceptionToDomainMapper
    ): MemberRepository = MemberRepositoryImpl(
        memberCloudDataSource = memberCloudDataSource,
        memberToDomainMapper = memberToDomainMapper,
        httpExceptionToDomainMapper = httpExceptionToDomainMapper
    )

    @Provides
    fun provideGetMemberListUseCase(
        memberRepository: MemberRepository
    ): GetMemberListUseCase = GetMemberListUseCase(memberRepository)

}