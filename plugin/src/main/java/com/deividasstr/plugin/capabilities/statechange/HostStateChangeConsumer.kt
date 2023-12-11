package com.deividasstr.plugin.capabilities.statechange

import com.deividasstr.plugin.pluginstatechanges.HostStateChange

interface StateChangeConsumer<T : HostStateChange> {
    fun onStateChange(stateChange: T)
}
