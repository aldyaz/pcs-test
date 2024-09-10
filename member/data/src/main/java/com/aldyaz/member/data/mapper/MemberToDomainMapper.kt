package com.aldyaz.member.data.mapper

import com.aldyaz.datasource.member.model.MemberDto
import com.aldyaz.member.domain.model.MemberDomainModel

class MemberToDomainMapper : (MemberDto) -> MemberDomainModel {

    override fun invoke(p1: MemberDto): MemberDomainModel {
        val name = obtainFirstLastName(p1.name.orEmpty())
        return MemberDomainModel(
            id = p1.id.orEmpty(),
            firstName = name.first,
            lastName = name.second,
            avatarUrl = p1.avatar.orEmpty(),
            address = p1.street.orEmpty(),
            dob = p1.createdAt.orEmpty()
        )
    }

    private fun obtainFirstLastName(name: String): Pair<String, String> {
        var firstName = ""
        var lastName = ""
        val split = name.split("\\s+")
        firstName = split.firstOrNull().orEmpty()
        lastName = split.filterIndexed { index, _ -> index != 0 }.joinToString(" ")
        return firstName to lastName
    }
}