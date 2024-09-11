package com.aldyaz.member.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.aldyaz.common.domain.base.ResultState
import com.aldyaz.common.domain.coroutines.CoroutinesContextProvider
import com.aldyaz.common.presentation.viewmodel.BaseViewModel
import com.aldyaz.member.domain.interactor.GetMemberListUseCase
import com.aldyaz.member.presentation.intent.MemberListIntent
import com.aldyaz.member.presentation.model.MemberPresentationModel
import com.aldyaz.member.presentation.state.MemberListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemberListViewModel @Inject constructor(
    private val getMemberListUseCase: GetMemberListUseCase,
    private val coroutinesContextProvider: CoroutinesContextProvider
) : BaseViewModel<MemberListIntent>() {

    private val _state = MutableStateFlow(MemberListState.Initial)
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = MemberListState.Initial
    )

    override fun onIntentReceived(intent: MemberListIntent) {
        when (intent) {
            is MemberListIntent.OnEnter -> getMemberList()
        }
    }

    private fun getMemberList() = viewModelScope.launch(coroutinesContextProvider.io) {
        _state.updateState {
            copy(
                loading = true,
                error = false
            )
        }
        when (val result = getMemberListUseCase(Unit)) {
            is ResultState.Success -> {
                _state.updateState {
                    copy(
                        loading = false,
                        data = result.data.map {
                            MemberPresentationModel(
                                id = it.id,
                                firstName = it.firstName,
                                lastName = it.lastName,
                                avatarUrl = it.avatarUrl,
                                address = it.address,
                                dob = it.dob
                            )
                        }
                    )
                }
            }

            is ResultState.Error -> {
                _state.updateState {
                    copy(
                        loading = false,
                        error = true
                    )
                }
            }
        }
    }
}