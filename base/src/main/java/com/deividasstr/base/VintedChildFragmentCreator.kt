package com.vinted.feature.base.ui.builder

import android.os.Bundle
import com.vinted.core.navigation.navigator.FragmentResultRequestKey
import com.vinted.feature.base.ui.BaseFragment
import com.vinted.feature.base.ui.BaseUiFragment
import com.vinted.feature.base.ui.FragmentResultProvider
import javax.inject.Inject

class VintedChildFragmentCreator @Inject constructor(
        @PublishedApi internal val fragmentFactory: VintedChildFragmentFactory
) {

    @PublishedApi
    internal val classLoader = BaseFragment::class.java.classLoader!!

    inline fun <reified F : BaseFragment, T : Args<F>> create(args: T, crossinline body: T.() -> Bundle): F {
        return fragmentFactory.instantiate(classLoader, F::class.java.name).apply {
            this.arguments = args.body()
        } as F
    }

    inline fun <reified F, reified TResult, T : Args<F>> create(
            args: T,
            resultRequestKey: FragmentResultRequestKey<TResult>?,
            crossinline body: T.() -> Bundle,
    ): F where F : BaseUiFragment, F : FragmentResultProvider<TResult> {
        return (fragmentFactory.instantiate(classLoader, F::class.java.name) as F).apply {
            this.arguments = args.body().addResultRequestKey(resultRequestKey)
        }
    }
}
