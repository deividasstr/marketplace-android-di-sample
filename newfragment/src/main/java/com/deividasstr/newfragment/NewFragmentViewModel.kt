package com.deividasstr.newfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deividasstr.base.BaseDependency
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewFragmentViewModel @AssistedInject constructor(
    private val baseDep: BaseDependency,
    @Assisted private val arguments: Arguments,
): ViewModel() {

    fun getBaseDep() = baseDep.doSomething()

    data class Arguments(val login: String?)

    @AssistedFactory
    interface Factory {
        fun create(arguments: Arguments): NewFragmentViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            arguments: Arguments
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(arguments) as T
            }
        }
    }
}