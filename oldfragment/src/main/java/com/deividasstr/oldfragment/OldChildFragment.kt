package com.deividasstr.newfragment

import androidx.fragment.app.Fragment
import com.deividasstr.base.BaseFragment
import javax.inject.Inject

class NewChildFragment @Inject constructor(
    private val scopedDep: ScopedDep
) : BaseFragment() {

}