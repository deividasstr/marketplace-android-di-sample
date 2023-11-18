package com.deividasstr.plugin.pluginactions.progress

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ProgressCapability : ProgressProvider, ProgressConsumer

class ProgressCapabilityImpl : ProgressCapability {

    private val _state = MutableStateFlow(false)

    override fun setProgress(show: Boolean) {
        _state.value = show
    }

    override val isInProgress: StateFlow<Boolean> = _state.asStateFlow()
}
