package com.deividasstr.paymentplugin

import androidx.lifecycle.ViewModel
import com.deividasstr.plugin.Plugin
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class PaymentPluginModule {

    @Binds
    abstract fun bindPaymentPluginSide(pluginManager: PaymentPlugin): PaymentPluginContext

    @Binds
    @IntoSet
    abstract fun bindPaymentPlugin(pluginManager: PaymentPlugin): Plugin
}
