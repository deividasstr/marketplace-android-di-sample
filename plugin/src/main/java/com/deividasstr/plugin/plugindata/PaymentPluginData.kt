package com.deividasstr.plugin.plugindata

import com.deividasstr.plugin.PluginType
import com.deividasstr.plugin.plugindata.PluginData

data class PaymentPluginData(val data: String) : PluginData(pluginType = PluginType.PAYMENT)
