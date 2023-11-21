package com.deividasstr

import com.deividasstr.newfragment.NewFragmentModule
import com.deividasstr.newhost.NewHostComponent
import com.deividasstr.newhost.NewHostModule
import com.deividasstr.oldfragment.OldFragmentModule
import com.deividasstr.oldhost.OldHostModule
import dagger.Module

@Module(
    includes = [
        NewFragmentModule::class,
        OldHostModule::class,
        OldFragmentModule::class,
        //NewHostModule::class
    ]
)
abstract class FragmentModule