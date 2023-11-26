package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import com.deividasstr.base.ActivityScope
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.plugin.Plugin
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@ContributesTo(FragmentScope::class)
@Module(includes = [PaymentViewModule::class])
abstract class PaymentPluginModule {

    @Binds
    abstract fun bindPaymentPluginSide(pluginManager: PaymentPlugin): PaymentPluginContext

    @Binds
    @IntoSet
    abstract fun bindPaymentPlugin(pluginManager: PaymentPlugin): Plugin
}

@Module
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
