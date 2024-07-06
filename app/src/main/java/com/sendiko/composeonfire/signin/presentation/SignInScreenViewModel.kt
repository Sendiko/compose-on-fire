package com.sendiko.composeonfire.signin.presentation

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.sendiko.composeonfire.signin.data.SignInResult
import com.sendiko.composeonfire.signin.domain.SignInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInScreenViewModel @Inject constructor (
    private val repository: SignInRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SignInScreenState())
    val state = _state.asStateFlow()

    suspend fun signIn() = repository.signIn()

    suspend fun signInWithIntent(intent: Intent): SignInResult {
        return repository.signInWithIntent(intent)
    }

    fun onSignInResult(signInResult: SignInResult) {
        _state.update {
            it.copy(
                isSignInSuccessful = signInResult.data != null,
                signInErrorMessage = signInResult.errorMessage,
                isLoading = false
            )
        }
    }

    fun setLoadingState(isLoading: Boolean) {
        _state.update { it.copy(isLoading = isLoading) }
    }

    fun resetState() {
        _state.update { SignInScreenState() }
    }

}