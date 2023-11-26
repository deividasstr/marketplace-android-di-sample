package com.deividasstr.paymentplugin

import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.PluginType
import com.deividasstr.plugin.pluginactions.progress.ProgressCapability
import com.deividasstr.plugin.pluginactions.progress.ProgressCapabilityImpl
import com.deividasstr.plugin.pluginactions.progress.ProgressConsumer
import com.deividasstr.plugin.pluginactions.statechange.HostStateChangeCapability
import com.deividasstr.plugin.pluginactions.statechange.HostStateChangeCapabilityImpl
import com.deividasstr.plugin.pluginactions.statechange.StateChangeConsumer
import com.deividasstr.plugin.pluginactions.stateprovision.PluginStateCapability
import com.deividasstr.plugin.pluginactions.stateprovision.PluginStateCapabilityImpl
import com.deividasstr.plugin.pluginactions.stateprovision.PluginStateProvider
import com.deividasstr.plugin.pluginactions.ui.PluginViewCapability
import com.deividasstr.plugin.pluginactions.validation.ValidatableCapability
import com.deividasstr.plugin.pluginactions.validation.ValidatableCapabilityImpl
import com.deividasstr.plugin.pluginactions.validation.ValidityConsumer
import javax.inject.Inject

@SingleIn(FragmentScope::class)
class PaymentPlugin @Inject constructor() : Plugin,
    PaymentPluginContext,
    PluginStateCapability<PaymentPluginData> by PluginStateCapabilityImpl(
        initialPluginData = PaymentPluginData("")
    ),
    ProgressCapability by ProgressCapabilityImpl(),
    ValidatableCapability by ValidatableCapabilityImpl(),
    HostStateChangeCapability<PaymentHostStateChange> by HostStateChangeCapabilityImpl(),
    PluginViewCapability by PaymentPluginViewCapability() {
    override val pluginType: PluginType = PluginType.PAYMENT
}

interface PaymentPluginContext : PluginStateProvider<PaymentPluginData>,
    StateChangeConsumer<PaymentHostStateChange>,
    ValidityConsumer,
    ProgressConsumer
