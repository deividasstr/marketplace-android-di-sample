package com.deividasstr.plugin.capabilities.stateprovision

import com.deividasstr.plugin.capabilities.PluginCapability
import com.deividasstr.plugin.plugindata.PluginData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PluginStateCapability<T : PluginData>(
    override val initialPluginData: T
) : PluginStateProvider<T>, PluginStateConsumer<T>, PluginCapability {

    private val _state = MutableStateFlow(initialPluginData)
    override val hostState: StateFlow<T> = _state.asStateFlow()

    @Suppress("UNCHECKED_CAST")
    override fun setState(state: PluginData) {
        if (initialPluginData::class == state::class) {
            _state.value = state as T
        }
    }
}
