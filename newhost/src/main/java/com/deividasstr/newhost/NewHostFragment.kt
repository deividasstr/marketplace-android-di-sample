package com.deividasstr.newhost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.deividasstr.base.Args
import com.deividasstr.base.BaseFragment
import com.deividasstr.plugin.pluginactions.ui.PluginViewCapability
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewHostFragment @Inject constructor(
    private val viewModelAssistedFactory: NewHostViewModel.Factory
) : BaseFragment() {

    private val viewModel: NewHostViewModel by viewModels {
        NewHostViewModel.provideFactory(viewModelAssistedFactory, NewHostViewModel.Arguments(""))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_host_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val container = (view as ViewGroup)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { uiState ->
                    uiState.pluginViewCapabilities.forEach { viewProvider ->
                        viewProvider.addViewTo(container)
                    }
                }
            }
        }
    }

    private fun PluginViewCapability.addViewTo(container: ViewGroup) {
        //if (container.children.none { child -> child.tag == pluginType }) { // no views of this type added
        val view = createView(requireContext())
        view.tag = pluginType
        container.addView(view)
        //}
    }

    companion object : Args<NewHostFragment> {
        private const val FLOW = "flow"

        fun with(flow: String): Bundle {
            return bundleOf(FLOW to flow)
        }
    }
}
