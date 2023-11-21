package com.deividasstr

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.deividasstr.app.R
import com.deividasstr.base.Args
import com.deividasstr.base.BaseFragment
import com.deividasstr.base.VintedFragmentCreator
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject


class NavController(
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