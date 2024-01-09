package com.deividasstr.base

import android.os.Bundle
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
}
