package com.deividasstr.newfragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.deividasstr.di.AssistedSavedStateViewModelFactory
import com.deividasstr.di.BaseFragment
import com.deividasstr.di.FragmentKey
import com.deividasstr.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(NewFragment::class)
    abstract fun bindPaymentsAccountFragmentV2(fragment: NewFragment): BaseFragment

    @Binds
    @IntoMap
    @ViewModelKey(NewFragmentViewModel::class)
    abstract fun paymentsAccountViewModelV2(factory: NewFragmentViewModel.Factory):
            AssistedSavedStateViewModelFactory<NewFragmentViewModel.Arguments, out ViewModel>
}