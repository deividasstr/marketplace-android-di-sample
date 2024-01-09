package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.plugin.CheckoutPlugin
import com.deividasstr.plugin.Plugin
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module(includes = [PaymentViewModule::class])
abstract class PaymentPluginModule {

    @Binds
    abstract fun bindPaymentPluginSide(pluginManager: PaymentPluginImpl): PaymentPlugin

    @Binds
    @IntoSet
    abstract fun bindPaymentPlugin(pluginManager: PaymentPluginImpl): CheckoutPlugin
}

@Module
@ContributesTo(FragmentScope::class)
abstract class PaymentViewModule {

    @ContributesAndroidInjector(modules = [PaymentPluginViewModule::class])
    abstract fun contributesPaymentPluginView(): PaymentPluginView

    @Module
    abstract class PaymentPluginViewModule {

        @Binds
        @IntoMap
        @ViewModelKey(PaymentPluginViewModel::class)
        abstract fun contributesPaymentPluginViewModel(viewModel: PaymentPluginViewModel): ViewModel
    }
}
