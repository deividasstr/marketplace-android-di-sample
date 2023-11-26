package com.deividasstr

import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.PerApplicationScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/*@Module(*//*subcomponents = [DagActivityComponent::class]*//*)
abstract class ActivityModule {

     @PerActivityScope
     @ContributesAndroidInjector(
         modules = [
             ViewModelModule::class,
             BaseFragmentModule::class,
             FragmentModule::class,
         ]
     )
     abstract fun contributeActivity(): MainActivity
}*/

@Module(
    subcomponents = [
        MainActivitySubcomponent::class,
    ]
)
@ContributesTo(PerApplicationScope::class)
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(
        builder: MainActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@MergeSubcomponent(
    modules = [ViewModelModule::class, BaseFragmentModule::class, FragmentModule::class],
    scope = PerActivityScope::class
)
@PerActivityScope
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}
