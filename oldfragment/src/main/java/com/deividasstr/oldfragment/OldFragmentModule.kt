package com.deividasstr.oldfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.base.PerFragmentScope
import com.deividasstr.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class OldFragmentModule {

    @PerFragmentScope
    @ContributesAndroidInjector(modules = [OldFragmentInternalModule::class])
    internal abstract fun contributesOldFragment(): OldFragment

    @Module
    abstract class OldFragmentInternalModule {
        @ContributesAndroidInjector
        internal abstract fun contributesOldChildFragment(): OldChildFragment

        @Binds
        @IntoMap
        @ViewModelKey(OldFragmentViewModel::class)
        abstract fun contributesViewModel(viewModel: OldFragmentViewModel): ViewModel
    }
}