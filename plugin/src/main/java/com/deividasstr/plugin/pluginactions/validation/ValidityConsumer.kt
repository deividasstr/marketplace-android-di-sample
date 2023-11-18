package com.deividasstr.plugin.pluginactions.validation

import com.deividasstr.plugin.pluginactions.validation.ValidationEvent
import kotlinx.coroutines.flow.Flow

interface ValidityConsumer {
    fun setValidity(valid: Boolean)
    val validationEvents: Flow<ValidationEvent>
}
