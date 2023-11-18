package com.deividasstr.newfragment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.deividasstr.di.AssistedSavedStateViewModelFactory
import com.deividasstr.di.BaseDependency
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewFragmentViewModel @AssistedInject constructor(
    private val baseDep: BaseDependency,
    @Assisted private val arguments: Arguments,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    fun getBaseDep() = baseDep.doSomething()

    data class Arguments(val login: String?)

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<Arguments, NewFragmentViewModel> {
        override fun create(
            arguments: Arguments,
            savedStateHandle: SavedStateHandle
        ): NewFragmentViewModel
    }
}