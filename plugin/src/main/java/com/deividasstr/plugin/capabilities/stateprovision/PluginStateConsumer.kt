package com.deividasstr.plugin.capabilities.stateprovision

import com.deividasstr.plugin.plugindata.PluginData

interface PluginStateConsumer<T : PluginData> {
    val initialPluginData: T
    fun setState(state: PluginData)
}
