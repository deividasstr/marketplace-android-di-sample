package com.deividasstr.plugin.pluginactions.stateprovision

import com.deividasstr.plugin.plugindata.PluginData
import kotlinx.coroutines.flow.StateFlow

interface PluginStateProvider<T : PluginData> {
    val hostState: StateFlow<T>
}
