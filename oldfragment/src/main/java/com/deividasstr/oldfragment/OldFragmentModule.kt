package com.deividasstr.oldfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class OldFragmentModule {

    @ContributesAndroidInjector(modules = [OldFragmentInternalModule::class])
    internal abstract fun contributesOldFragment(): OldFragment

    @Module
    abstract class OldFragmentInternalModule {

        @Binds
        @IntoMap
        @ViewModelKey(OldFragmentViewModel::class)
        abstract fun contributesViewModel(viewModel: OldFragmentViewModel): ViewModel
    }
}