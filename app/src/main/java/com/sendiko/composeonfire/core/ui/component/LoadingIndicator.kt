package com.sendiko.composeonfire.core.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *
 * The loading indicator
 *
 * @param isLoading to determine if loading indicator should show.
 *
 * */
@Composable
fun LoadingIndicator(
    isLoading: Boolean,
) {
    AnimatedVisibility(
        visible = isLoading,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            content = {
                Row(
                    modifier = Modifier.padding(top = 28.dp + 8.dp, end = 8.dp, start = 8.dp, bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Loading",
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CircularProgressIndicator(modifier = Modifier.size(24.dp), strokeWidth = 1.dp)
                }
            }
        )
    }
}