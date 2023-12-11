package com.deividasstr.plugin.capabilities.stateprovision

import com.deividasstr.plugin.plugindata.PluginData
import kotlinx.coroutines.flow.StateFlow

interface PluginStateProvider<T : PluginData> {
    val hostState: StateFlow<T>
}
