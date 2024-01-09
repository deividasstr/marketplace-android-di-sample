package com.vinted.feature.base.ui.builder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.vinted.dagger.PerFragmentScope
import javax.inject.Inject

/*@ContributesTo(
        scope = PerFragmentScope::class,
        replaces = [FragmentFactory::class]
)*/
@PerFragmentScope
class VintedChildFragmentFactory @Inject constructor(
        private val fragmentComponentFactory: FragmentSubcomponent.Factory
) : FragmentFactory() {

    val fragmentComponent: FragmentSubcomponent by lazy { fragmentComponentFactory.create() }

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        val fragment = fragmentComponent.getFragmentMap()[fragmentClass]?.get()

        return fragment ?: super.instantiate(classLoader, className)
    }
}
