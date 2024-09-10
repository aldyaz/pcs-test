package com.aldyaz.member.presentation.viewmodel

import com.aldyaz.common.presentation.viewmodel.BaseViewModel
import com.aldyaz.member.presentation.intent.MemberSharedIntent
import com.aldyaz.member.presentation.model.MemberPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MemberSharedViewModel @Inject constructor() : BaseViewModel<MemberSharedIntent>() {

    private val _member = MutableStateFlow(MemberPresentationModel.Initial)
    val member: StateFlow<MemberPresentationModel>
        get() = _member.asStateFlow()

    override fun onIntentReceived(intent: MemberSharedIntent) {
        when (intent) {
            is MemberSharedIntent.OnSelectMember -> {
                _member.updateState {
                    intent.member
                }
            }
        }
    }
}