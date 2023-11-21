package com.deividasstr.oldfragment

import androidx.lifecycle.ViewModel
import com.deividasstr.base.BaseDependency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OldFragmentViewModel @Inject constructor(
    private val baseDep: BaseDependency
): ViewModel() {

        fun getBaseDep() = baseDep.doSomething()
}