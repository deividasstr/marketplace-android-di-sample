package com.deividasstr.plugin.capabilities.statechange

import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import kotlinx.coroutines.flow.SharedFlow

interface StateChangeProvider<T : HostStateChange> {
    val stateChangedFlow: SharedFlow<T>
}
