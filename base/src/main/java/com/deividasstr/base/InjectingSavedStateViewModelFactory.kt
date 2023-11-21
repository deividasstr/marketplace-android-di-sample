package com.deividasstr.base

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Inject

class InjectingSavedStateViewModelFactory<Args : Any> @Inject constructor(
        private val assistedFactories: Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<Args, out ViewModel>>
) {
    fun create(owner: SavedStateRegistryOwner, arguments: Args): AbstractSavedStateViewModelFactory {
        return object : AbstractSavedStateViewModelFactory(owner, null) {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                // Attempt to get ViewModel from assisted inject factories
                assistedFactories[modelClass]?.let {
                    try {
                        return it.create(arguments, handle) as T
                    } catch (e: Exception) {
                        throw RuntimeException(e)
                    }
                } ?: throw IllegalArgumentException("Unknown model class $modelClass")
            }
        }
    }
}
