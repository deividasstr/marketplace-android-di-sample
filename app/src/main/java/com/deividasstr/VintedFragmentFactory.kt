package com.deividasstr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.deividasstr.base.ActivityScope
import com.deividasstr.base.BaseFragment
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject
import javax.inject.Provider

typealias FragmentMap = Map<Class<out BaseFragment>, @JvmSuppressWildcards Provider<BaseFragment>>

@ContributesBinding(ActivityScope::class)
class VintedFragmentFactory @Inject constructor(
    private val fragmentComponentFactory: FragmentProvidersSubcomponent.Factory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentComponent = fragmentComponentFactory.create()
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragmentMap = fragmentComponent.getFragmentMap()
        return fragmentMap[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
    }
}
