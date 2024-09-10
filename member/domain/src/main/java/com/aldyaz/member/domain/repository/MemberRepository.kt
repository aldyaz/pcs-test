package com.aldyaz.member.domain.repository

import com.aldyaz.common.domain.base.ResultState
import com.aldyaz.member.domain.model.MemberDomainModel

interface MemberRepository {

    suspend fun getMemberList(): ResultState<List<MemberDomainModel>>

}