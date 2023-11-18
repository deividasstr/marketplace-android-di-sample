package com.deividasstr.di

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment: Fragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjectorr: DispatchingAndroidInjector<Any>

    private fun isInjected() = this::androidInjectorr.isInitialized

    override fun onAttach(context: Context) {
        if (!isInjected()) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjectorr
    }
}