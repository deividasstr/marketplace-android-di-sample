package com.deividasstr.base

import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Provider

@SingleIn(FragmentScope::class)
@ContributesSubcomponent(scope = FragmentScope::class, parentScope = ActivityScope::class)
interface FragmentSubcomponent {

    fun getFragmentMap(): Map<Class<out BaseFragment>, @JvmSuppressWildcards Provider<BaseFragment>>

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): FragmentSubcomponent
    }

    @ContributesTo(ActivityScope::class)
    interface Parent {
        fun provideSubcomponent(): Factory
    }
}
