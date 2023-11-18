package com.deividasstr.di

import android.view.View
import dagger.android.AndroidInjector

interface HasViewInjector {
    fun viewInjector(): AndroidInjector<View>
}
