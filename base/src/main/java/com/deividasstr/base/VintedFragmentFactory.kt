package com.deividasstr.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class VintedFragmentFactory @Inject constructor(
        private val provider: Map<Class<out BaseFragment>, @JvmSuppressWildcards Provider<BaseFragment>>
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragment = provider[fragmentClass]?.get()

        return fragment ?: super.instantiate(classLoader, className)
    }
}
