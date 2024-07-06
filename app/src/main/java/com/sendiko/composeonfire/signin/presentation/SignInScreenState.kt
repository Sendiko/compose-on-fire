package com.sendiko.composeonfire.signin.presentation

data class SignInScreenState(
    val isSignInSuccessful: Boolean = false,
    val isLoading: Boolean = false,
    val signInErrorMessage: String? = null,
)
