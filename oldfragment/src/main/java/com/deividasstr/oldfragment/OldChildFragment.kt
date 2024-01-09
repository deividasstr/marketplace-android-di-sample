package com.deividasstr.oldfragment

import com.deividasstr.base.BaseFragment
import javax.inject.Inject

class OldChildFragment : BaseFragment() {

    @Inject
    lateinit var scopedDep: ScopedDep

}