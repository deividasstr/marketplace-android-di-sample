package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.PerApplicationScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.PluginType
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesMultibinding
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import com.squareup.anvil.annotations.compat.MergeModules
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Inject

//@ContributesTo(CheckoutPluginScope::class)
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
