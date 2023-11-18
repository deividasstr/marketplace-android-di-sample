package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import com.deividasstr.di.CheckoutPluginScope
import com.deividasstr.di.PerActivityScope
import com.deividasstr.di.PerApplicationScope
import com.deividasstr.di.PerFragmentScope
import com.deividasstr.di.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPlugin
import com.deividasstr.paymentplugin.PaymentPluginContext
import com.deividasstr.plugin.Plugin
import com.deividasstr.plugin.PluginType
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesMultibinding
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Inject

@ContributesTo(PerActivityScope::class)
@Module(includes = [PaymentViewModule::class])
abstract class PaymentPluginModule {

    @Binds
    abstract fun bindPaymentPluginSide(pluginManager: PaymentPlugin): PaymentPluginContext

    @Binds
    @IntoSet
    abstract fun bindPaymentPlugin(pluginManager: PaymentPlugin): Plugin
}

//@ContributesMultibinding(PerApplicationScope::class)
@ContributesBinding(PerActivityScope::class, boundType = Plugin::class)
class PiPl @Inject constructor() : Plugin {
    override val pluginType: PluginType
        get() = PluginType.PAYMENT
}

@Module
abstract class PaymentViewModule {

    //@CheckoutPluginScope
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
