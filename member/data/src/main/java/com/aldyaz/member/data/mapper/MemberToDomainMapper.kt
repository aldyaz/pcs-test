package com.aldyaz.member.data.mapper

import com.aldyaz.datasource.member.model.MemberDto
import com.aldyaz.member.domain.model.MemberDomainModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MemberToDomainMapper : (MemberDto) -> MemberDomainModel {

    override fun invoke(p1: MemberDto): MemberDomainModel {
        val name = obtainFirstLastName(p1.name.orEmpty())
        val address = "${p1.street.orEmpty()}, ${p1.addressNo.orEmpty()}, " +
            "${p1.county.orEmpty()}, ${p1.country.orEmpty()}. ${p1.zipCode.orEmpty()}"
        return MemberDomainModel(
            id = p1.id.orEmpty(),
            firstName = name.first,
            lastName = name.second,
            avatarUrl = p1.avatar.orEmpty(),
            address = address,
            dob = formatDate(p1.createdAt)
        )
    }

    private fun obtainFirstLastName(name: String): Pair<String, String> {
        val firstName: String
        val lastName: String
        val split = name.trim().split(Regex("\\s+"))
        firstName = split.firstOrNull().orEmpty()
        lastName = split.filterIndexed { index, _ -> index > 0 }.joinToString(" ")
        return firstName to lastName
    }

    private fun formatDate(dateString: String?): String = dateString?.let {
        try {
            val localDate = LocalDateTime.parse(
                it,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            )
            val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
            formatter.format(localDate)
        } catch (err: Exception) {
            err.printStackTrace()
            ""
        }
    }.orEmpty()
}