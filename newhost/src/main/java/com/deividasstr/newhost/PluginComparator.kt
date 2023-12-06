package com.deividasstr.newhost

import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.PluginType
import javax.inject.Inject

class PluginComparator @Inject constructor() {

    private val pluginOrder = listOf(
        PluginType.PAYMENT,
        PluginType.CHECKOUT,
        PluginType.SHIPPING,
        PluginType.SUMMARY
    )

    val comparator: Comparator<Plugin> = Comparator { o1, o2 ->
        pluginOrder.indexOf(o1.pluginType) - pluginOrder.indexOf(o2.pluginType)
    }
}