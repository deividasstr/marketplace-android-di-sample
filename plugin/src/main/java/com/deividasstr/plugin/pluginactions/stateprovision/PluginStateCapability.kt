package com.deividasstr.plugin.pluginactions.stateprovision

import com.deividasstr.plugin.plugindata.PluginData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface PluginStateCapability<T : PluginData> : PluginStateProvider<T>, PluginStateConsumer<T>

class PluginStateCapabilityImpl<T : PluginData>(override val initialPluginData: T) :
    PluginStateCapability<T> {

    private val _state = MutableStateFlow(initialPluginData)
    override val hostState: StateFlow<T> = _state.asStateFlow()

    @Suppress("UNCHECKED_CAST")
    override fun setState(state: PluginData) {
        if (initialPluginData::class == state::class) {
            _state.value = state as T
        }
    }
}
