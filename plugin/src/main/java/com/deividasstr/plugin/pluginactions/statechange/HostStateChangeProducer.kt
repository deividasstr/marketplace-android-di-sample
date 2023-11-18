package com.deividasstr.plugin.pluginactions.statechange

import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import kotlinx.coroutines.flow.SharedFlow

interface StateChangeProvider<T : HostStateChange> {
    val stateChangedFlow: SharedFlow<T>
}
