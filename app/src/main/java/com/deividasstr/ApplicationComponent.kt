package com.deividasstr

import com.deividasstr.base.ApplicationScope
import com.deividasstr.base.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@SingleIn(ApplicationScope::class)
@MergeComponent(
    scope = ApplicationScope::class,
    modules = [
        AndroidSupportInjectionModule::class,
    ],
)
interface ApplicationComponent : AndroidInjector<App> {

    fun getActivityComponentFactory(): MainActivitySubcomponent.Factory
    @Component.Factory
    interface Factory {
        fun build(@BindsInstance application: App): ApplicationComponent
    }
}