package com.deividasstr.oldfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.di.BaseDependency
import javax.inject.Inject

class OldFragmentViewModel @Inject constructor(
    private val baseDep: BaseDependency
): ViewModel() {

        fun getBaseDep() = baseDep.doSomething()
}