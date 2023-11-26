package com.deividasstr.plugin.di

import com.deividasstr.base.ActivityScope
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent

@MergeSubcomponent(scope = ActivityScope::class)
interface CheckoutPluginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CheckoutPluginComponent
    }
}

/*@ContributesTo(PerApplicationScope::class)
@Module(subcomponents = [CheckoutPluginComponent::class])
interface CheckoutPluginModule*/
