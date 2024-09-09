package com.aldyaz.datasource.member.source

import com.aldyaz.datasource.member.model.MemberDto
import com.aldyaz.datasource.remote.model.HttpSourceState

interface MemberCloudDataSource {

    suspend fun getMemberList(): HttpSourceState<List<MemberDto>>

}