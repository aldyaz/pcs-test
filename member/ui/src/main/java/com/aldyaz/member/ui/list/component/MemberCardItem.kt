package com.aldyaz.member.ui.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aldyaz.member.presentation.model.MemberPresentationModel
import com.aldyaz.member.ui.R

@Composable
fun MemberCardItem(
    item: MemberPresentationModel,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .clickable {
                onClick?.invoke()
            }
            .then(modifier)
    ) {
        Row {
            AsyncImage(
                model = item.avatarUrl,
                contentDescription = stringResource(R.string.label_content_desc_member_avatar),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "${item.firstName} ${item.lastName}")
                Text(text = item.dob)
            }
        }
    }
}
