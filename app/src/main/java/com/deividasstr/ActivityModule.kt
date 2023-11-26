package com.deividasstr

import com.deividasstr.base.ActivityScope
import com.deividasstr.base.ApplicationScope
import com.deividasstr.base.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@ContributesTo(ApplicationScope::class)
@Module
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(
        builder: MainActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@MergeSubcomponent(
    modules = [ViewModelModule::class],
    scope = ActivityScope::class
)
@SingleIn(ActivityScope::class)
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}
