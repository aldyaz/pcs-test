package com.aldyaz.member.domain.interactor

import com.aldyaz.common.domain.base.ResultState
import com.aldyaz.common.domain.interactor.UseCase
import com.aldyaz.member.domain.model.MemberDomainModel
import com.aldyaz.member.domain.repository.MemberRepository

class GetMemberListUseCase(
    private val memberRepository: MemberRepository
) : UseCase<Unit, List<MemberDomainModel>>() {

    override suspend fun execute(param: Unit): ResultState<List<MemberDomainModel>> {
        return memberRepository.getMemberList()
    }
}