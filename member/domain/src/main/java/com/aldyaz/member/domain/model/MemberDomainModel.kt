package com.aldyaz.member.domain.model

data class MemberDomainModel(
    val firstName: String,
    val lastName: String,
    val avatarUrl: String,
    val address: String,
    val dob: String
)