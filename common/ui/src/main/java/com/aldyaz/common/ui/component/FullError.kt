package com.aldyaz.common.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aldyaz.common.ui.R

@Composable
fun FullError(
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.label_default_error_message)
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onRetryClick,
            content = {
                Text(text = stringResource(R.string.label_try_again))
            }
        )
    }
}

@Preview
@Composable
fun FullErrorPreview() {
    FullError(onRetryClick = { /*TODO*/ })
}
