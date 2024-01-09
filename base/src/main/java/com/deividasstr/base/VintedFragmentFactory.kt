package com.deividasstr.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(ActivityScope::class)
class VintedFragmentFactory @Inject constructor(
    private val fragmentComponentFactory: FragmentSubcomponent.Factory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentComponent = fragmentComponentFactory.create()
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragmentMap = fragmentComponent.getFragmentMap()
        return fragmentMap[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
    }
}
