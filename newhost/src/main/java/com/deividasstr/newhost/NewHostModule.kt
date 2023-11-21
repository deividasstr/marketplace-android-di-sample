package com.deividasstr.newhost

import androidx.lifecycle.ViewModel
import com.deividasstr.base.AssistedSavedStateViewModelFactory
import com.deividasstr.base.BaseFragment
import com.deividasstr.base.FragmentKey
import com.deividasstr.base.PerActivityScope
import com.deividasstr.base.PerApplicationScope
import com.deividasstr.base.PerFragmentScope
import com.deividasstr.base.ViewModelKey
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Module(subcomponents = [NewHostComponent::class])
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

@Module
abstract class NewHostViewModelModule {

/*    @Binds
    @IntoMap
    @ViewModelKey(NewHostViewModel::class)
    abstract fun paymentsAccountViewModelV2(factory: NewHostViewModel.Factory):
            AssistedSavedStateViewModelFactory<NewHostViewModel.Arguments, out ViewModel>*/
/*    @Binds
    @IntoMap
    @ViewModelKey(NewHostViewModel::class)
    abstract fun contributesCheViewModel(viewModel: NewHostViewModel): ViewModel*/
}

@Subcomponent(
    modules = [
        NewHostViewModelModule::class,
        PaymentPluginModule::class
    ])
@PerFragmentScope
interface NewHostComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewHostComponent
    }
}
