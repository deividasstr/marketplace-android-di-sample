package com.deividasstr.newhost

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deividasstr.base.AssistedSavedStateViewModelFactory
import com.deividasstr.plugin.capabilities.stateprovision.PluginStateConsumer
import com.deividasstr.plugin.capabilities.validation.ValidityProvider
import com.deividasstr.plugin.plugindata.PaymentPluginData
import com.deividasstr.plugin.plugindata.PluginData
import com.deividasstr.plugin.pluginstatechanges.HostStateChange
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

class NewHostViewModel @AssistedInject constructor(
    private val pluginManager: PluginManager,
    @Assisted private val arguments: Arguments,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(NewHostState(listOf()))
    val state: StateFlow<NewHostState> = _state
    private val pluginStateConsumers: List<PluginStateConsumer<out PluginData>> = pluginManager.getPluginStateProvider()
    private val pluginValidityConsumers: List<ValidityProvider> = pluginManager.getPluginValidationConsumers()

    init {
        init(listOf(PaymentPluginData("data")))
    }

    fun init(pluginData: List<PluginData>) { // retrieved from backend
        val newState = NewHostState(pluginManager.getPluginViewProviders())
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

    data class Arguments(val login: String?)

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<Arguments, NewHostViewModel> {
        override fun create(
            arguments: Arguments,
            savedStateHandle: SavedStateHandle
        ): NewHostViewModel
    }
}
