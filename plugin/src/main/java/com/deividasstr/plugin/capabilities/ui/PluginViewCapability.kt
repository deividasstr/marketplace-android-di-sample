package com.deividasstr.plugin.capabilities.ui

import android.content.Context
import android.view.View
import com.deividasstr.plugin.capabilities.PluginCapability

class PluginViewCapability(val creator: (Context) -> View) : PluginCapability