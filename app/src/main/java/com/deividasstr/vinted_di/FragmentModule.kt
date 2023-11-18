package com.deividasstr.vinted_di

import com.deividasstr.oldhost.OldHostModule
import com.deividasstr.newfragment.NewFragmentModule
import com.deividasstr.newhost.NewHostModule
import com.deividasstr.oldfragment.OldFragmentModule
import com.deividasstr.paymentplugin.PaymentPluginModule
import com.deividasstr.paymentplugin.PaymentViewModule
import dagger.Module

@Module(
    includes = [
        NewFragmentModule::class,
        //NewHostModule::class,
        //OldHostModule::class,
        OldFragmentModule::class,
    ]
)
abstract class FragmentModule