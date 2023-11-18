package com.deividasstr.vinted_di

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerApplicationComponent.factory()
            .build(this)
    }

}