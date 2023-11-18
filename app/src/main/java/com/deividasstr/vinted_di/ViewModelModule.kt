package com.deividasstr.vinted_di

import androidx.lifecycle.ViewModelProvider
import com.deividasstr.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}