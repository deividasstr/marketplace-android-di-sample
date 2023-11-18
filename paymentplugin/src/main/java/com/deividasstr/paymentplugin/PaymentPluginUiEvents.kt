package com.deividasstr.paymentplugin

sealed class PaymentPluginUiEvents {
    object ScrollToValidation : PaymentPluginUiEvents()
    object ShowValidation : PaymentPluginUiEvents()
}
