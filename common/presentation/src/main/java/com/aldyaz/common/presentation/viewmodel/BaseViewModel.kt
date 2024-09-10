package com.aldyaz.common.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<INTENT> : ViewModel() {

    abstract fun onIntentReceived(intent: INTENT)

    protected fun <T> MutableStateFlow<T>.updateState(
        state: T.() -> T
    ) {
        update {
            state(it)
        }
    }

}