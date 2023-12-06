package com.deividasstr.plugin

import com.deividasstr.plugin.capabilities.PluginCapability

interface Plugin {
    val pluginType: PluginType
    val capabilities: List<PluginCapability>
}
