package com.deividasstr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.deividasstr.base.BaseFragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import javax.inject.Provider

//As per https://proandroiddev.com/constructor-injection-into-fragments-with-respect-of-scopes-311c0258d678
class VintedFragmentFactory @Inject constructor(
    private val androidInjector: DispatchingAndroidInjector<Any>
) : FragmentFactory() {

    private val providers = FragmentProviders()

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        androidInjector.inject(providers)

        val clazz = loadFragmentClass(classLoader, className)
        return providers[clazz]?.get() ?: super.instantiate(classLoader, className)
    }

    class FragmentProviders {

        @Inject
        lateinit var fragmentProviders: MutableMap<Class<out BaseFragment>, Provider<BaseFragment>>
        operator fun get(clazz: Class<out Fragment>) = fragmentProviders[clazz]
    }
}
