package com.deividasstr.plugin.capabilities.validation

import kotlinx.coroutines.flow.StateFlow

interface ValidityProvider {
    val isValidFlow: StateFlow<Boolean>
    fun showValidation()
    fun scrollToValidation()
}
