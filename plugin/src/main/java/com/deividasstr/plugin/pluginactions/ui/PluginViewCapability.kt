package com.deividasstr.plugin.pluginactions.ui

import android.content.Context
import android.view.View
import com.deividasstr.plugin.PluginType

interface PluginViewCapability {
    val pluginType: PluginType
    fun createView(context: Context): View
}
