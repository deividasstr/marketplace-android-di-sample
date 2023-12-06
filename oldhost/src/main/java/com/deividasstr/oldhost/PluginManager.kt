package com.deividasstr.oldhost

import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.capabilities.progress.ProgressProvider
import com.deividasstr.plugin.capabilities.statechange.StateChangeProvider
import com.deividasstr.plugin.capabilities.stateprovision.PluginStateConsumer
import com.deividasstr.plugin.capabilities.ui.PluginViewCapability
import com.deividasstr.plugin.capabilities.validation.ValidityProvider
import com.deividasstr.plugin.plugindata.PluginData
import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import javax.inject.Inject

class PluginManager @Inject constructor(private val plugins: @JvmSuppressWildcards Set<Plugin>) {


    fun getPluginStateProvider(): List<PluginStateConsumer<out PluginData>> {
        return plugins.flatMap { it.capabilities }.filterIsInstance<PluginStateConsumer<out PluginData>>()
    }

    fun getPluginProgressConsumers(): List<ProgressProvider> {
        return plugins.flatMap { it.capabilities }.filterIsInstance<ProgressProvider>()
    }

    fun getPluginValidationConsumers(): List<ValidityProvider> {
        return plugins.flatMap { it.capabilities }.filterIsInstance<ValidityProvider>()
    }

    fun getPluginStateChangeConsumer(): List<StateChangeProvider<HostStateChange>> {
        return plugins.flatMap { it.capabilities }.filterIsInstance<StateChangeProvider<HostStateChange>>()
    }

    fun getPluginViewProviders(): List<PluginViewCapability> {
        return plugins.flatMap { it.capabilities }.filterIsInstance<PluginViewCapability>()
    }
}
