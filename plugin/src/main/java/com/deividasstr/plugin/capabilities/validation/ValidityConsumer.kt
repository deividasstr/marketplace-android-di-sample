package com.deividasstr.plugin.capabilities.validation

import kotlinx.coroutines.flow.Flow

interface ValidityConsumer {
    fun setValidity(valid: Boolean)
    val validationEvents: Flow<ValidationEvent>
}
