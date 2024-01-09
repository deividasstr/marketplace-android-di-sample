package com.deividasstr.paymentplugin

import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.deividasstr.plugin.CheckoutPlugin
import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.CheckoutPluginType
import com.deividasstr.plugin.capabilities.progress.ProgressCapability
import com.deividasstr.plugin.capabilities.statechange.HostStateChangeCapability
import com.deividasstr.plugin.capabilities.stateprovision.PluginStateCapability
import com.deividasstr.plugin.capabilities.ui.PluginViewCapability
import com.deividasstr.plugin.capabilities.validation.ValidatableCapability
import com.deividasstr.plugin.plugindata.PaymentPluginData
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

//@Plugin(CheckoutPlugin::class)
abstract class PaymentPlugin : CheckoutPlugin() {
    override val pluginType: CheckoutPluginType = CheckoutPluginType.PAYMENT

    val stateCapability by Capability {
        PluginStateCapability(initialPluginData = PaymentPluginData(""))
    }
    val progressCapability by Capability { ProgressCapability() }
    val validatableCapability by Capability { ValidatableCapability() }
    val hostStateChangeCapability by Capability { HostStateChangeCapability<PaymentHostStateChange>() }
    private val viewCapability by Capability {
        PluginViewCapability { context -> PaymentPluginView(context) }
    }
}

// To be generated by @Plugin
@SingleIn(FragmentScope::class)
@ContributesBinding(FragmentScope::class)
@ContributesMultibinding(FragmentScope::class, boundType = CheckoutPlugin::class)
class PaymentPluginImpl @Inject constructor() : PaymentPlugin()


