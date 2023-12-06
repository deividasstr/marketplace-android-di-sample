package com.deividasstr

import com.deividasstr.base.ActivityScope
import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import dagger.Subcomponent

/*@ContributesTo(ActivityScope::class)
@Module(subcomponents = [FragmentProvidersSubcomponent::class])
abstract class BaseFragmentModule*/

@SingleIn(FragmentScope::class)
@ContributesSubcomponent(scope = FragmentScope::class, parentScope = ActivityScope::class)
interface FragmentSubcomponent {

    fun getFragmentMap(): FragmentMap

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): FragmentSubcomponent
    }

    @ContributesTo(ActivityScope::class)
    interface Parent {
        fun provideSubcomponent(): FragmentSubcomponent.Factory
    }
}
