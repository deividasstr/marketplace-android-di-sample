package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deividasstr.plugin.pluginactions.validation.ValidationEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class PaymentPluginViewModel @Inject constructor(
    private val paymentPluginContext: PaymentPluginContext,
) : ViewModel() {

    // Generate UI state - react to the host state
    val state = paymentPluginContext.hostState
        .onEach { paymentPluginContext.setValidity(it.isValid()) } // let the host know that content is valid or not
        .map {
            val stateText = if (it.data.isNotEmpty()) {
                    "Payment plugin vm, con $paymentPluginContext, data ${it.data}"
                } else {
                    ""
                }
            // to plugin ui state
            PaymentPluginState(stateText)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = PaymentPluginState("")
        )

    // regular android VM events
    private val _events = MutableSharedFlow<PaymentPluginUiEvents>(extraBufferCapacity = 5)
    val events = _events.asSharedFlow()

    init {
        // React to host validation events
        paymentPluginContext.validationEvents.onEach { event ->
            when (event) {
                ValidationEvent.ScrollToValidation -> _events.tryEmit(PaymentPluginUiEvents.ScrollToValidation)
                ValidationEvent.ShowValidation -> _events.tryEmit(PaymentPluginUiEvents.ShowValidation)
            }
        }.launchIn(viewModelScope)
    }

    fun paymentChanged(payment: String) {
        // Update host state
        paymentPluginContext.onStateChange(PaymentHostStateChange(payment))
    }

    fun doSomethingLong() {
        paymentPluginContext.setProgress(show = true)
        // do something
        paymentPluginContext.setProgress(show = false)
    }

    // checked in the reaction to new state
    private fun PaymentPluginData.isValid(): Boolean {
        return this.data.isNotBlank()
    }
}
