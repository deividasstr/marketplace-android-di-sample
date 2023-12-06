package com.deividasstr.plugin.capabilities.statechange

import com.deividasstr.plugin.capabilities.PluginCapability
import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class HostStateChangeCapability<T : HostStateChange> : StateChangeProvider<T>,
    StateChangeConsumer<T>,
    PluginCapability {

    private val _stateChangeFlow = MutableSharedFlow<T>(extraBufferCapacity = 5)

    override fun onStateChange(stateChange: T) {
        _stateChangeFlow.tryEmit(stateChange)
    }

    override val stateChangedFlow: SharedFlow<T> = _stateChangeFlow.asSharedFlow()
}
