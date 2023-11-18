package com.deividasstr.vinted_di

import com.deividasstr.di.PerApplicationScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule

@PerApplicationScope
@MergeComponent(
    scope = PerApplicationScope::class,
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun build(@BindsInstance application: App): ApplicationComponent
    }
}