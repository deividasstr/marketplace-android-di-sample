package com.deividasstr.plugin.capabilities.progress

import com.deividasstr.plugin.capabilities.PluginCapability
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProgressCapability : ProgressProvider, ProgressConsumer, PluginCapability {

    private val _state = MutableStateFlow(false)

    override fun setProgress(show: Boolean) {
        _state.value = show
    }

    override val isInProgress: StateFlow<Boolean> = _state.asStateFlow()
}
