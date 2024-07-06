package com.sendiko.composeonfire.signin.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sendiko.composeonfire.R
import com.sendiko.composeonfire.core.ui.component.ContentBoxWithNotification
import com.sendiko.composeonfire.core.ui.theme.ComposeOnFireTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    state: SignInScreenState,
    onSignInClick: () -> Unit
) {
    ContentBoxWithNotification(
        message = if (state.isSignInSuccessful) "Sign in Successful" else state.signInErrorMessage.toString(),
        isErrorNotification = state.signInErrorMessage != null,
        isLoading = state.isLoading
    ) {
        Scaffold {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp).fillMaxSize()
            ) {
                Text(
                    text = "WayToYourDreams",
                    fontWeight = Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = "Manage your Savings and Wishlist better",
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.height(48.dp))
                Button(
                    onClick = onSignInClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Sign in with ")
                        Icon(
                            painter = painterResource(id = R.drawable.mdi_google),
                            contentDescription = "Google"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Sign in as Guest")
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignInScreenPrev() {
    ComposeOnFireTheme {
//        SignInScreen()
    }
}