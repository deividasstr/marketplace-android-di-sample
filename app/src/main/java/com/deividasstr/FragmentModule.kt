package com.deividasstr

import com.deividasstr.base.ActivityScope
import com.deividasstr.base.ApplicationScope
import com.deividasstr.newfragment.NewFragmentModule
import com.deividasstr.newhost.NewHostModule
import com.deividasstr.oldfragment.OldFragmentModule
import com.deividasstr.oldhost.OldHostModule
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module

@Module(
    includes = [
        NewFragmentModule::class,
        OldHostModule::class,
        OldFragmentModule::class,
        //NewHostModule::class
    ]
)
@ContributesTo(ActivityScope::class)
abstract class FragmentModule