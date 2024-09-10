package com.aldyaz.member.ui.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.aldyaz.member.presentation.model.MemberPresentationModel
import com.aldyaz.member.presentation.viewmodel.MemberSharedViewModel
import com.aldyaz.member.ui.R

@Composable
fun MemberDetailPage(
    sharedViewModel: MemberSharedViewModel,
    onBackPressed: (() -> Unit)? = null
) {
    val member by sharedViewModel.member.collectAsStateWithLifecycle()

    BackHandler(
        enabled = onBackPressed != null,
        onBack = {
            onBackPressed?.invoke()
        }
    )

    MemberDetailScaffold(member = member)
}

@Composable
private fun MemberDetailScaffold(
    member: MemberPresentationModel
) {
    Scaffold { contentPadding ->
        MemberDetailContent(
            member = member,
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
private fun MemberDetailContent(
    member: MemberPresentationModel,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.padding(
                vertical = 16.dp
            )
        ) {
            AsyncImage(
                model = member.avatarUrl,
                contentDescription = stringResource(R.string.label_content_desc_member_avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = "First name: ${member.firstName}",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Last name: ${member.lastName}",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Address: ${member.address}",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
    }
}
