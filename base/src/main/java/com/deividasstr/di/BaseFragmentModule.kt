package com.deividasstr.di


import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module

@Module
abstract class BaseFragmentModule {

    @Binds
    abstract fun bindFragmentFactory(vintedFragmentFactory: VintedFragmentFactory): FragmentFactory

}
