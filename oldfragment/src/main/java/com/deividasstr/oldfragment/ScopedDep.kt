package com.deividasstr.oldfragment

import com.deividasstr.base.FragmentScope
import com.deividasstr.base.PerFragmentScope
import com.deividasstr.base.SingleIn
import javax.inject.Inject

@PerFragmentScope
class ScopedDep @Inject constructor() {
    init {
        println("AAA init ScopedDep $this")
    }
}