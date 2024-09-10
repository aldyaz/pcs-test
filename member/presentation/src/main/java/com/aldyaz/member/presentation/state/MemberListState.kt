package com.aldyaz.member.presentation.state

import com.aldyaz.member.presentation.model.MemberPresentationModel

data class MemberListState(
    val loading: Boolean = true,
    val error: Boolean = false,
    val data: List<MemberPresentationModel> = listOf()
) {

    val success = !loading && !error

    companion object {
        val Initial = MemberListState()
    }
}