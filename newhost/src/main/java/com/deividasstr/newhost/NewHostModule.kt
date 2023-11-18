package com.deividasstr.newhost

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.deividasstr.di.BaseFragment
import com.deividasstr.di.FragmentKey
import com.deividasstr.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewHostModule {

    @Binds
    @IntoMap
    @FragmentKey(NewHostFragment::class)
    abstract fun bindPaymentsAccountFragmentV2(fragment: NewHostFragment): BaseFragment

    @Binds
    @IntoMap
    @ViewModelKey(NewHostViewModel::class)
    abstract fun contributesCheViewModel(viewModel: NewHostViewModel): ViewModel
}

