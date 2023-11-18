package com.deividasstr.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface AssistedSavedStateViewModelFactory<Args: Any, T : ViewModel> {
    fun create(arguments: Args, savedStateHandle: SavedStateHandle): T
}
