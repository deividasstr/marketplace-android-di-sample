package com.deividasstr.plugin.pluginactions.validation

sealed class ValidationEvent {
    object ScrollToValidation : ValidationEvent()
    object ShowValidation : ValidationEvent()
}
