package com.aldyaz.datasource.member.source

import com.aldyaz.datasource.member.cloud.MemberService
import com.aldyaz.datasource.member.model.MemberDto
import com.aldyaz.datasource.remote.extension.apiCall
import com.aldyaz.datasource.remote.model.HttpSourceState
import javax.inject.Inject

class MemberCloudDataSourceImpl @Inject constructor(
    private val memberService: MemberService
) : MemberCloudDataSource {

    override suspend fun getMemberList(): HttpSourceState<List<MemberDto>> {
        return apiCall {
            memberService.getMemberList()
        }
    }
}