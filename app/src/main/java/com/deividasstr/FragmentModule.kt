package com.deividasstr

import com.deividasstr.base.BaseFragment
import com.deividasstr.base.FragmentKey
import com.deividasstr.newfragment.NewFragment
import com.deividasstr.newhost.NewHostFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class FragmentFactoryModule {

    @Binds
    @IntoMap
    @FragmentKey(NewFragment::class)
    abstract fun bindFirstScreenFragment(fragment: NewFragment): BaseFragment

    @Binds
    @IntoMap
    @FragmentKey(NewHostFragment::class)
    abstract fun bindSecondScreenFragment(fragment: NewHostFragment): BaseFragment
}