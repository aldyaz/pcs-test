package com.aldyaz.member.presentation.model

data class MemberPresentationModel(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val avatarUrl: String = "",
    val address: String = "",
    val dob: String = ""
) {

    companion object {
        val Initial = MemberPresentationModel()
    }
}