package com.deividasstr.plugin

import com.deividasstr.plugin.capabilities.PluginCapability
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class Plugin {
    private val _capabilities = mutableListOf<PluginCapability>()
    val capabilities: List<PluginCapability> = _capabilities

    inner class Capability<F : Plugin, T : PluginCapability>(
        init: () -> T
    ) : ReadOnlyProperty<F, T> {

        private val capability: T = init().also {
            _capabilities.add(it)
        }

        override fun getValue(thisRef: F, property: KProperty<*>): T {
            return capability
        }
    }

    fun <F : Plugin, T : PluginCapability> F.capability(init: () -> T, ): ReadOnlyProperty<F, T> {
        return Capability(init)
    }
}
