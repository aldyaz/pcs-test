package com.aldyaz.member.data.repository

import com.aldyaz.common.data.mapper.HttpExceptionToDomainMapper
import com.aldyaz.common.domain.base.ResultState
import com.aldyaz.datasource.member.source.MemberCloudDataSource
import com.aldyaz.datasource.remote.model.HttpSourceState
import com.aldyaz.member.data.mapper.MemberToDomainMapper
import com.aldyaz.member.domain.model.MemberDomainModel
import com.aldyaz.member.domain.repository.MemberRepository

class MemberRepositoryImpl(
    private val memberCloudDataSource: MemberCloudDataSource,
    private val memberToDomainMapper: MemberToDomainMapper,
    private val httpExceptionToDomainMapper: HttpExceptionToDomainMapper
) : MemberRepository {

    override suspend fun getMemberList(): ResultState<List<MemberDomainModel>> {
        return when (val result = memberCloudDataSource.getMemberList()) {
            is HttpSourceState.Success -> ResultState.Success(
                result.data.map(memberToDomainMapper)
            )

            is HttpSourceState.Error -> ResultState.Error(
                httpExceptionToDomainMapper(result.exception)
            )
        }
    }
}