package com.deividasstr.newfragment

import com.deividasstr.base.FragmentScope
import com.deividasstr.base.SingleIn
import javax.inject.Inject

@SingleIn(FragmentScope::class)
class ScopedDep @Inject constructor() {
    init {
        println("AAA init ScopedDep $this")
    }
}