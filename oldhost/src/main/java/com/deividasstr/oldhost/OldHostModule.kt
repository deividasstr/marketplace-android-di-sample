package com.deividasstr.oldhost

import androidx.lifecycle.ViewModel
import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPluginModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class OldHostModule {

    @CheckoutPluginScope
    @ContributesAndroidInjector(modules = [OldHostInternalModule::class, PaymentPluginModule::class])
    abstract fun contributesOldHostFragment(): OldHostFragment

    @Module
    abstract class OldHostInternalModule {

        @Binds
        @IntoMap
        @ViewModelKey(OldHostViewModel::class)
        abstract fun contributesViewModel(viewModel: OldHostViewModel): ViewModel
    }
}
