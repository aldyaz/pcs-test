package com.aldyaz.member.data.mapper

import com.aldyaz.datasource.member.model.MemberDto
import com.aldyaz.member.domain.model.MemberDomainModel

class MemberToDomainMapper : (MemberDto) -> MemberDomainModel {

    override fun invoke(p1: MemberDto): MemberDomainModel {
        TODO("Not yet implemented")
    }
}