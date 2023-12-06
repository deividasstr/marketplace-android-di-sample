package com.deividasstr.plugin.capabilities.validation

sealed class ValidationEvent {
    object ScrollToValidation : ValidationEvent()
    object ShowValidation : ValidationEvent()
}
