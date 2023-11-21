package com.deividasstr.newfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.deividasstr.base.Args
import com.deividasstr.base.BaseFragment
import com.deividasstr.newfragment.databinding.FragmentNewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewFragment @Inject constructor(
    private val viewModelAssistedFactory: NewFragmentViewModel.Factory
) : BaseFragment() {

    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!


    private val viewModel: NewFragmentViewModel by viewModels {
        NewFragmentViewModel.provideFactory(viewModelAssistedFactory, NewFragmentViewModel.Arguments(""))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newFragmentTextView.text = "New fragment: ${viewModel.getBaseDep()}"
    }

    companion object : Args<NewFragment> {
        private const val FLOW = "flow"

        fun with(flow: String): Bundle {
            return bundleOf(FLOW to flow)
        }
    }
}