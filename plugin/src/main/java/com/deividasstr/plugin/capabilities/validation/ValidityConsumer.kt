package com.deividasstr.plugin.capabilities.validation

import com.deividasstr.plugin.PluginContext
import kotlinx.coroutines.flow.Flow

interface ValidityConsumer : PluginContext {
    fun setValidity(valid: Boolean)
    val validationEvents: Flow<ValidationEvent>
}
