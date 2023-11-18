package com.deividasstr.vinted_di

import com.deividasstr.di.BaseFragmentModule
import com.deividasstr.di.PerActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivityScope
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class,
            ViewModelModule::class,
            BaseFragmentModule::class,
        ]
    )
    abstract fun contributeMDActivity(): MainActivity
}