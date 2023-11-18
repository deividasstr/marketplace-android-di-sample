package com.deividasstr.plugin.pluginactions.statechange

import com.deividasstr.plugin.pluginstatechanges.HostStateChange

interface StateChangeConsumer<T : HostStateChange> {
    fun onStateChange(stateChange: T)
}
