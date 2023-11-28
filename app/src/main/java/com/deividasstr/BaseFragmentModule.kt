package com.deividasstr

import com.deividasstr.base.ActivityScope
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Module
import dagger.Subcomponent

@ContributesTo(ActivityScope::class)
@Module(subcomponents = [FragmentProvidersSubcomponent::class])
abstract class BaseFragmentModule

@SingleIn(FragmentScope::class)
@MergeSubcomponent(scope = FragmentScope::class)
interface FragmentProvidersSubcomponent {

    fun getFragmentMap(): FragmentMap

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProvidersSubcomponent
    }
}
