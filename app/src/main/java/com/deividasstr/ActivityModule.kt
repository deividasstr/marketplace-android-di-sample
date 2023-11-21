package com.deividasstr

import com.deividasstr.FragmentModule
import com.deividasstr.MainActivity
import com.deividasstr.ViewModelModule
import com.deividasstr.base.BaseFragmentModule
import com.deividasstr.base.PerActivityScope
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