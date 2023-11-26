package com.deividasstr

import com.deividasstr.base.PerApplicationScope
import com.deividasstr.plugin.di.CheckoutPluginComponent
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplicationScope
@MergeComponent(
    scope = PerApplicationScope::class,
    modules = [
        AndroidSupportInjectionModule::class,
        //ActivityModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<App> {
    //fun inject(activity: MainActivity)
    //fun activityComponent(): ActivityComponent.Factory
    //abstract fun contributeActivity(): MainActivity
    @Component.Factory
    interface Factory {
        fun build(@BindsInstance application: App): ApplicationComponent
    }
}