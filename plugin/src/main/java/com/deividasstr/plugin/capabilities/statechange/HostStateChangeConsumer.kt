package com.deividasstr.plugin.capabilities.statechange

import com.deividasstr.plugin.PluginContext
import com.deividasstr.plugin.pluginstatechanges.HostStateChange

interface StateChangeConsumer<T : HostStateChange> : PluginContext {
    fun onStateChange(stateChange: T)
}
