package com.aldyaz.member.presentation.intent

import com.aldyaz.member.presentation.model.MemberPresentationModel

sealed class MemberSharedIntent {

    data class OnSelectMember(
        val member: MemberPresentationModel
    ) : MemberSharedIntent()

}