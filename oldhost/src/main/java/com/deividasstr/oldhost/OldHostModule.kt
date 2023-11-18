package com.deividasstr.oldhost

import androidx.lifecycle.ViewModel
import com.deividasstr.di.CheckoutPluginScope
import com.deividasstr.di.PerActivityScope
import com.deividasstr.di.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
@ContributesTo(PerActivityScope::class)
abstract class OldHostModule {

    //@CheckoutPluginScope
    @ContributesAndroidInjector(modules = [OldHostInternalModule::class])
    abstract fun contributesOldHostFragment(): OldHostFragment

    @Module
    abstract class OldHostInternalModule {

        @Binds
        @IntoMap
        @ViewModelKey(OldHostViewModel::class)
        abstract fun contributesViewModel(viewModel: OldHostViewModel): ViewModel
    }
}


