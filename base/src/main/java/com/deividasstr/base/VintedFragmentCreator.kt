package com.deividasstr.base

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

/**
 * This builder works only with fragments, which implements [Args] on the companion object.
 * Example:
 * ```
 *  vintedFragmentCreator.create(Foo) { with(a) }
 * ```
 */
class VintedFragmentCreator @Inject constructor(@PublishedApi internal val fragmentFactory: FragmentFactory) {

    @PublishedApi
    internal val classLoader = BaseFragment::class.java.classLoader!!

    inline fun <reified F : BaseFragment, T : Args<F>> create(args: T, crossinline body: T.() -> Bundle): F {
        return fragmentFactory.instantiate(classLoader, F::class.java.name).apply {
            this.arguments = args.body()
        } as F
    }
}
