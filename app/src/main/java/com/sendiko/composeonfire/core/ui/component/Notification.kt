package com.sendiko.composeonfire.core.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *
 * The notification that will be shown.
 *
 * @param message the message that will be shown.
 * @param isVisible when the notification comes up.
 * @param isErrorNotification shown red notification.
 *
 * */
@Composable
fun Notification(
    message: String,
    isVisible: Boolean,
    isErrorNotification: Boolean = false,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(if (isErrorNotification) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.surfaceVariant),
            content = {
                Text(
                    text = message,
                    modifier = Modifier.padding(top = 28.dp + 8.dp, end = 8.dp, start = 8.dp, bottom = 16.dp),
                    color = if (isErrorNotification) MaterialTheme.colorScheme.onError else MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        )
    }
}