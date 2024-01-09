package com.deividasstr.newfragment

import javax.inject.Inject

class ScopedDep @Inject constructor() {
    init {
        println("AAA init ScopedDep $this")
    }
}