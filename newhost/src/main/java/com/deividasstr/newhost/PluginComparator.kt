package com.deividasstr.newhost

import com.deividasstr.plugin.CheckoutPlugin
import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.CheckoutPluginType
import javax.inject.Inject

class PluginComparator @Inject constructor() {

    private val pluginOrder = listOf(
        CheckoutPluginType.PAYMENT,
        CheckoutPluginType.CHECKOUT,
        CheckoutPluginType.SHIPPING,
        CheckoutPluginType.SUMMARY
    )

    val comparator: Comparator<CheckoutPlugin> = Comparator { o1, o2 ->
        pluginOrder.indexOf(o1.pluginType) - pluginOrder.indexOf(o2.pluginType)
    }
}