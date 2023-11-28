package com.deividasstr

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().build(this)
    }
    override fun applicationInjector(): AndroidInjector<App> {
        return appComponent
    }

}