package com.deividasstr.plugin.pluginactions.statechange

import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface HostStateChangeCapability<T : HostStateChange> : StateChangeProvider<T>,
    StateChangeConsumer<T>

class HostStateChangeCapabilityImpl<T : HostStateChange> : HostStateChangeCapability<T> {

    private val _stateChangeFlow = MutableSharedFlow<T>(extraBufferCapacity = 5)

    override fun onStateChange(stateChange: T) {
        _stateChangeFlow.tryEmit(stateChange)
    }

    override val stateChangedFlow: SharedFlow<T> = _stateChangeFlow.asSharedFlow()
}
