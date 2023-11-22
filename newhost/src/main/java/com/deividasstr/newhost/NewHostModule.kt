package com.deividasstr.newhost

import androidx.lifecycle.ViewModel
import com.deividasstr.base.AssistedSavedStateViewModelFactory
import com.deividasstr.base.BaseFragment
import com.deividasstr.base.FragmentKey
import com.deividasstr.base.ViewModelKey
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
    abstract fun paymentsAccountViewModelV2(factory: NewHostViewModel.Factory):
            AssistedSavedStateViewModelFactory<NewHostViewModel.Arguments, out ViewModel>
}
