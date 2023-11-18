package com.deividasstr.plugin.di

import com.deividasstr.di.CheckoutPluginScope
import com.deividasstr.di.PerActivityScope
import com.deividasstr.di.PerApplicationScope
import com.deividasstr.di.PerFragmentScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Module
import dagger.Subcomponent

@MergeSubcomponent(scope = CheckoutPluginScope::class)
interface CheckoutPluginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CheckoutPluginComponent
    }
}

@ContributesTo(PerApplicationScope::class)
@Module(subcomponents = [CheckoutPluginComponent::class])
interface CheckoutPluginModule
