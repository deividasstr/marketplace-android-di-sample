package com.deividasstr

import androidx.lifecycle.ViewModelProvider
import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.ViewModelFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}