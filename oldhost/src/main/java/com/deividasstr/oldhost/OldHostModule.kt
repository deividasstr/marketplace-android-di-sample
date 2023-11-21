package com.deividasstr.oldhost

import androidx.lifecycle.ViewModel
import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.PerFragmentScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class OldHostModule {

    @PerFragmentScope
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
