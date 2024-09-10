package com.aldyaz.member.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldyaz.common.ui.component.FullError
import com.aldyaz.common.ui.component.FullLoading
import com.aldyaz.common.ui.component.ScreenEnterObserver
import com.aldyaz.member.presentation.intent.MemberListIntent
import com.aldyaz.member.presentation.intent.MemberSharedIntent
import com.aldyaz.member.presentation.model.MemberPresentationModel
import com.aldyaz.member.presentation.state.MemberListState
import com.aldyaz.member.presentation.viewmodel.MemberListViewModel
import com.aldyaz.member.presentation.viewmodel.MemberSharedViewModel
import com.aldyaz.member.ui.list.component.MemberCardItem

@Composable
fun MemberListPage(
    onClickItem: () -> Unit,
    sharedViewModel: MemberSharedViewModel,
    viewModel: MemberListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ScreenEnterObserver {
        viewModel.onIntentReceived(MemberListIntent.OnEnter)
    }

    MemberListScaffold(
        state = state,
        onRetryClick = {
            viewModel.onIntentReceived(MemberListIntent.OnEnter)
        },
        onClickItem = {
            sharedViewModel.onIntentReceived(MemberSharedIntent.OnSelectMember(it))
            onClickItem()
        }
    )
}

@Composable
private fun MemberListScaffold(
    state: MemberListState,
    onRetryClick: () -> Unit,
    onClickItem: (MemberPresentationModel) -> Unit
) {
    Scaffold { contentPadding ->
        MemberListContent(
            state = state,
            onRetryClick = onRetryClick,
            onClickItem = onClickItem,
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
private fun MemberListContent(
    state: MemberListState,
    onRetryClick: () -> Unit,
    onClickItem: (MemberPresentationModel) -> Unit,
    modifier: Modifier = Modifier
) {
    when {
        state.loading -> FullLoading(modifier = modifier)
        state.error -> FullError(
            onRetryClick = onRetryClick,
            modifier = modifier
        )

        state.success -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),
                modifier = modifier
            ) {
                items(state.data) { item ->
                    MemberCardItem(
                        item = item,
                        onClick = {
                            onClickItem(item)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
