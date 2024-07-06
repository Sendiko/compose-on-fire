package com.sendiko.composeonfire.core.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

/**
 * Sendiko's custom notification composables!.
 *
 * @param message for the message that will be shown in the notification.
 * @param isErrorNotification error notification will show with red color.
 * @param isLoading show loading indicator notification.
 * @param content for the screen content inside.
 *
 * */
@Composable
fun ContentBoxWithNotification(
    message: String,
    isErrorNotification: Boolean = false,
    isLoading: Boolean = false,
    content: @Composable (() -> Unit),
) {
    Box {
        content()
        Notification(
            message = message,
            isVisible = message.isNotBlank() && !isLoading,
            isErrorNotification = isErrorNotification
        )
        LoadingIndicator(isLoading = isLoading)
    }
}