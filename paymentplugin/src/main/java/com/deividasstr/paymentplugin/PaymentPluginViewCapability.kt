package com.deividasstr.paymentplugin

import android.content.Context
import android.view.View
import com.deividasstr.paymentplugin.PaymentPluginView
import com.deividasstr.plugin.PluginType
import com.deividasstr.plugin.pluginactions.ui.PluginViewCapability

class PaymentPluginViewCapability : PluginViewCapability {

    override val pluginType: PluginType = PluginType.PAYMENT
    override fun createView(context: Context): View {
        return PaymentPluginView(context)
    }
}
