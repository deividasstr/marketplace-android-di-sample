package com.deividasstr.newfragment

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.deividasstr.base.Args
import com.deividasstr.base.BaseFragment
import javax.inject.Inject

class NewChildFragment @Inject constructor(
    private val scopedDep: ScopedDep
) : BaseFragment() {

    companion object : Args<NewChildFragment> {
        private const val FLOW = "flow"

        fun with(flow: String): Bundle {
            return bundleOf(FLOW to flow)
        }
    }
}