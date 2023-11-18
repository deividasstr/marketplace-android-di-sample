package com.deividasstr.vinted_di

import android.os.Bundle
import android.view.animation.AnimationSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.deividasstr.di.Args
import com.deividasstr.di.BaseFragment
import com.deividasstr.di.PerActivityScope
import com.deividasstr.di.VintedFragmentCreator
import javax.inject.Inject

@PerActivityScope
class NavController @Inject constructor(
    val vintedFragmentCreator: VintedFragmentCreator,
    val activity: MainActivity,
) {
    inline fun <reified F, T : Args<F>> goTo(
        fragment: T,
        crossinline args: T.() -> Bundle,
    ) where F : BaseFragment {
        val newFragment = vintedFragmentCreator.create(fragment, args)

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment)
            .addToBackStack(fragment.javaClass.name)
            .commitAllowingStateLoss()
    }

    fun goTo(fragment: Fragment) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commitAllowingStateLoss()
    }
}