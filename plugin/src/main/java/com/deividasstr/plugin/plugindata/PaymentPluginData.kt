package com.deividasstr.plugin.plugindata

import com.deividasstr.plugin.CheckoutPluginType

data class PaymentPluginData(val data: String) : PluginData(pluginType = CheckoutPluginType.PAYMENT)
