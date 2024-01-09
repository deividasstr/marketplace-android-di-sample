package com.deividasstr.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

/*@ContributesTo(
        scope = PerFragmentScope::class,
        replaces = [FragmentFactory::class]
)*/
class VintedChildFragmentFactory @Inject constructor(
        private val fragmentComponentFactory: FragmentChildSubcomponent.Factory
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragmentComponent = fragmentComponentFactory.create()
        val fragment = fragmentComponent.getFragmentMap()[fragmentClass]?.get()

        return fragment ?: super.instantiate(classLoader, className)
    }
}
