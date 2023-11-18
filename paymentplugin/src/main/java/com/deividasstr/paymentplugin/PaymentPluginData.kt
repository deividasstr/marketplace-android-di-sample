package com.deividasstr.paymentplugin

import com.deividasstr.plugin.PluginType
import com.deividasstr.plugin.plugindata.PluginData

data class PaymentPluginData(val data: String) : PluginData() {
    override val pluginType: PluginType
        get() = PluginType.PAYMENT
}
