package com.deividasstr


import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.PerFragmentScope
import com.deividasstr.paymentplugin.PaymentPluginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BaseFragmentModule {

    @PerFragmentScope
    @CheckoutPluginScope
    @ContributesAndroidInjector(modules = [PaymentPluginModule::class])
    abstract fun contributeFragmentFactory(): VintedFragmentFactory.FragmentProviders
}
