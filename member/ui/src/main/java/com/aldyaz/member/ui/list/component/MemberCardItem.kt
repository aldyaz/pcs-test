@file:OptIn(ExperimentalMaterialApi::class)

package com.aldyaz.member.ui.list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
        onClick = {
            onClick?.invoke()
        },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp,
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .then(modifier)
    ) {
        Row {
            AsyncImage(
                model = item.avatarUrl,
                contentDescription = stringResource(R.string.label_content_desc_member_avatar),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(
                        width = 160.dp,
                        height = 140.dp
                    )
            )
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "${item.firstName} ${item.lastName}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.dob)
            }
        }
    }
}

@Preview
@Composable
fun MemberCardItemPreview() {
    MemberCardItem(
        item = MemberPresentationModel(
            id = "",
            firstName = "Emmett",
            lastName = "Dietrich",
            avatarUrl = "https://loremflickr.com/640/480/people",
            address = "Bednar Crossroad",
            dob = "2024-08-25T21:17:00.287Z"
        )
    )
}
