package com.deividasstr.oldfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.deividasstr.di.BaseFragment
import com.deividasstr.di.ViewModelFactory
import com.deividasstr.oldfragment.databinding.FragmentOldBinding
import javax.inject.Inject

class OldFragment : BaseFragment() {

    private var _binding: FragmentOldBinding? = null
    private val binding get() = _binding!!

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: OldFragmentViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOldBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.oldFragmentTextView.text = "Old fragment: ${viewModel.getBaseDep()}"
    }
}