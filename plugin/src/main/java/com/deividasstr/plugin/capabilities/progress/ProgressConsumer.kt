package com.deividasstr.plugin.capabilities.progress

import com.deividasstr.plugin.PluginContext

interface ProgressConsumer : PluginContext {
    fun setProgress(show: Boolean)
}
