package com.deividasstr.base

import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Provider

@ContributesSubcomponent(scope = FragmentChildScope::class, parentScope = FragmentScope::class)
interface FragmentChildSubcomponent {

    fun getFragmentMap(): Map<Class<out BaseFragment>, @JvmSuppressWildcards Provider<BaseFragment>>

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): FragmentChildSubcomponent
    }

    @ContributesTo(PerFragmentScope::class)
    interface Parent {
        fun provideSubcomponent(): Factory
    }
}
