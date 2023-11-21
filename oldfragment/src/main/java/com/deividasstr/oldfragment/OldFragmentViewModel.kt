package com.deividasstr.oldfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.base.BaseDependency
import javax.inject.Inject

class OldFragmentViewModel @Inject constructor(
    private val baseDep: BaseDependency
): ViewModel() {

        fun getBaseDep() = baseDep.doSomething()
}