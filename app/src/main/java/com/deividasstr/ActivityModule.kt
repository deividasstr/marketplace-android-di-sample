package com.deividasstr

import com.deividasstr.base.PerActivityScope
import com.deividasstr.newfragment.NewFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivityScope
    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            BaseFragmentModule::class,
            FragmentModule::class,
        ]
    )
    abstract fun contributeMDActivity(): MainActivity
}