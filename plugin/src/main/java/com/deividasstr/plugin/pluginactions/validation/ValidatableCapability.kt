package com.deividasstr.plugin.pluginactions.validation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

interface ValidatableCapability : ValidityConsumer, ValidityProvider

class ValidatableCapabilityImpl : ValidatableCapability {

    private val _state = MutableStateFlow(false)
    private val _validations = MutableSharedFlow<ValidationEvent>(extraBufferCapacity = 5)

    override val isValidFlow: StateFlow<Boolean> = _state.asStateFlow()

    override fun setValidity(valid: Boolean) {
        _state.value = valid
    }

    override val validationEvents: Flow<ValidationEvent> = _validations.asSharedFlow()

    override fun showValidation() {
        _validations.tryEmit(ValidationEvent.ShowValidation)
    }

    override fun scrollToValidation() {
        _validations.tryEmit(ValidationEvent.ScrollToValidation)
    }
}
