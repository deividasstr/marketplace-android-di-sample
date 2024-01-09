package com.deividasstr.newfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.base.AssistedSavedStateViewModelFactory
import com.deividasstr.base.BaseFragment
import com.deividasstr.base.FragmentChildScope
import com.deividasstr.base.FragmentKey
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.FragmentSubcomponent
import com.deividasstr.base.ViewModelKey
import com.squareup.anvil.annotations.ContributesTo
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

@Module
@ContributesTo(FragmentChildScope::class)
abstract class NewFragmentChildModule {

    @Binds
    @IntoMap
    @FragmentKey(NewChildFragment::class)
    abstract fun bindNewChildFragment(fragment: NewChildFragment): BaseFragment
}