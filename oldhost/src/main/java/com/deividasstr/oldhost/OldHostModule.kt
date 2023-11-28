package com.deividasstr.oldhost

import androidx.lifecycle.ViewModel
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.deividasstr.base.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPluginModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class OldHostModule {

    @SingleIn(FragmentScope::class)
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
