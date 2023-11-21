package com.deividasstr.plugin.di

import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.PerApplicationScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Module
import dagger.Subcomponent

@MergeSubcomponent(scope = PerApplicationScope::class)
interface CheckoutPluginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CheckoutPluginComponent
    }
}

/*@ContributesTo(PerApplicationScope::class)
@Module(subcomponents = [CheckoutPluginComponent::class])
interface CheckoutPluginModule*/
