package com.aldyaz.member.presentation.intent

sealed class MemberListIntent {

    data object OnEnter : MemberListIntent()

}