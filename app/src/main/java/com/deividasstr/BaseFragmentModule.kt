package com.deividasstr


import com.deividasstr.base.ActivityScope
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@ContributesTo(ActivityScope::class)
@Module(subcomponents = [FragmentProvidersSubcomponent::class])
abstract class BaseFragmentModule {
    @Binds
    @IntoMap
    @ClassKey(FragmentProviders::class)
    abstract fun bindAndroidInjectorFactory(
        builder: FragmentProvidersSubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@SingleIn(FragmentScope::class)
@MergeSubcomponent(
    scope = FragmentScope::class,
// UNSOLVABLE - there should be no need to directly know dependant module here.
// It fails now as the dependants lie in a separate module.
// ContributesSubcomponent should be used instead of MergeSubcomponent.
// But it requires for factory to not extend AndroidInjector.Factory
    modules = [PaymentPluginModule::class]
)
interface FragmentProvidersSubcomponent : AndroidInjector<FragmentProviders> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<FragmentProviders>
}

