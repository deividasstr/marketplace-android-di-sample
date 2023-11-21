package com.deividasstr.base

import android.view.View
import dagger.android.AndroidInjector

interface HasViewInjector {
    fun viewInjector(): AndroidInjector<View>
}
