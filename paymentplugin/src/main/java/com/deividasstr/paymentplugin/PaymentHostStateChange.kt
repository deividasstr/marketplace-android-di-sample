package com.deividasstr.paymentplugin

import com.deividasstr.plugin.pluginstatechanges.HostStateChange

data class PaymentHostStateChange(val fullPayInMethod: String) : HostStateChange()
