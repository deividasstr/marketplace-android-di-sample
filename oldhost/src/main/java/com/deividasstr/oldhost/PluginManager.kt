package com.deividasstr.oldhost

import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.pluginactions.progress.ProgressProvider
import com.deividasstr.plugin.pluginactions.statechange.StateChangeProvider
import com.deividasstr.plugin.pluginactions.stateprovision.PluginStateConsumer
import com.deividasstr.plugin.pluginactions.ui.PluginViewCapability
import com.deividasstr.plugin.pluginactions.validation.ValidityProvider
import com.deividasstr.plugin.plugindata.PluginData
import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import javax.inject.Inject

class PluginManager @Inject constructor(
        private val plugins: @JvmSuppressWildcards Set<Plugin>
) {

    fun getPluginStateProvider(): List<PluginStateConsumer<out PluginData>> {
        return plugins.toList().filterIsInstance<PluginStateConsumer<out PluginData>>()
    }

    fun getPluginProgressConsumers(): List<ProgressProvider> {
        return plugins.filterIsInstance<ProgressProvider>()
    }

    fun getPluginValidationConsumers(): List<ValidityProvider> {
        return plugins.filterIsInstance<ValidityProvider>()
    }

    fun getPluginStateChangeConsumer(): List<StateChangeProvider<HostStateChange>> {
        return plugins.filterIsInstance<StateChangeProvider<HostStateChange>>()
    }

    fun getPluginViewProviders(): List<PluginViewCapability> {
        return plugins.filterIsInstance<PluginViewCapability>()
    }
}
