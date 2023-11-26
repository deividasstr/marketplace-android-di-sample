package com.deividasstr


import com.deividasstr.base.CheckoutPluginScope
import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.PerApplicationScope
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.squareup.anvil.annotations.ContributesMultibinding
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [BaseFragmentModule.FragmentProvidersSubcomponent::class])
abstract class BaseFragmentModule {

/*    @CheckoutPluginScope
    @ContributesAndroidInjector(
        modules = [
            PaymentPluginModule::class,
        ])
    abstract fun contributeFragmentFactory(): FragmentProviders*/

    //@Module
    //@ContributesTo(PerActivityScope::class)
    //abstract class ActivityBindingsModule {
        @Binds
        @IntoMap
        @ClassKey(FragmentProviders::class)
        abstract fun bindAndroidInjectorFactory(
            builder: FragmentProvidersSubcomponent.Factory?
        ): AndroidInjector.Factory<*>?
    //}

    //@Subcomponent(modules = [PaymentPluginModule::class])
    @CheckoutPluginScope
    //@MergeSubcomponent(
    @Subcomponent(
        //scope = CheckoutPluginScope::class,
        modules = [
            PaymentPluginModule::class,
        ]
    )
    interface FragmentProvidersSubcomponent : AndroidInjector<FragmentProviders?> {
        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<FragmentProviders?>
    }
}
