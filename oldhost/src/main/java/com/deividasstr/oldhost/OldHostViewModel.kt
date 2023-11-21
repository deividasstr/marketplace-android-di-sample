package com.deividasstr.oldhost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deividasstr.paymentplugin.PaymentPluginData
import com.deividasstr.plugin.pluginactions.stateprovision.PluginStateConsumer
import com.deividasstr.plugin.pluginactions.validation.ValidityProvider
import com.deividasstr.plugin.plugindata.PluginData
import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class OldHostViewModel @Inject constructor(
        private val pluginManager: PluginManager
) : ViewModel() {

    private val _state = MutableStateFlow(OldHostState(listOf()))
    val state: StateFlow<OldHostState> = _state
    private val pluginStateConsumers: List<PluginStateConsumer<out PluginData>> = pluginManager.getPluginStateProvider()
    private val pluginValidityConsumers: List<ValidityProvider> = pluginManager.getPluginValidationConsumers()

    init {
        init(listOf(PaymentPluginData("data")))
    }

    fun init(pluginData: List<PluginData>) { // retrieved from backend
        val newState = OldHostState(pluginManager.getPluginViewProviders())
        onNewCheckoutState(pluginData)
        _state.value = newState
    }

    //Implement a way to check if all plugins are not in progress
    private val isInProgressFlow = combine(pluginManager
            .getPluginProgressConsumers()
            .map { it.isInProgress }) { inProgressList ->
        inProgressList.any { true }
    }.onEach {
        // show progress
    }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

    //Implement a way to check if all plugins are valid
    private val isEverythingValid = combine(pluginValidityConsumers
            .map { it.isValidFlow }) { isValidList ->
        isValidList.none { false }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

    init {
        // observe state change events
        pluginManager.getPluginStateChangeConsumer()
                .map { it.stateChangedFlow }
                .merge()
                .onEach(::onCheckoutChangeEvent)
                .launchIn(viewModelScope)
    }

    private fun onCheckoutChangeEvent(event: HostStateChange) {
        // React to plugin state changing events
    }

    private fun onNewCheckoutState(state: List<PluginData>) {
        // setting new state for all plugins
        state.forEach { pluginData ->
            pluginStateConsumers.forEach { it.setState(pluginData) }
        }
    }

    fun showValidations() {
        // Show validation in all plugins
        pluginValidityConsumers.forEach { it.showValidation() }
    }

    fun scrollToValidation() {
        // Make first plugin scroll to itself
        pluginValidityConsumers.first { !it.isValidFlow.value }.scrollToValidation()
    }
}
