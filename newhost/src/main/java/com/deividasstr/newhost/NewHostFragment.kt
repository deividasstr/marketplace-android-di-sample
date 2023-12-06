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
import com.deividasstr.base.HasViewInjector
import com.deividasstr.base.InjectingSavedStateViewModelFactory
import com.deividasstr.plugin.capabilities.ui.PluginViewCapability
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewHostFragment @Inject constructor(
    private val viewInjector: DispatchingAndroidInjector<View>,
    private val viewModelFactory: InjectingSavedStateViewModelFactory<NewHostViewModel.Arguments>
) : BaseFragment(), HasViewInjector {

    private val viewModel: NewHostViewModel by viewModels {
        viewModelFactory.create(this, NewHostViewModel.Arguments(""))
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
                    container.removeAllViews()
                    uiState.pluginViewCapabilities
                        .forEach { viewProvider -> viewProvider.addViewTo(container) }
                }
            }
        }
    }

    private fun PluginViewCapability.addViewTo(container: ViewGroup) {
        val view = creator(container.context)
        container.addView(view)
    }

    override fun viewInjector(): AndroidInjector<View> {
        return viewInjector
    }

    companion object : Args<NewHostFragment> {
        private const val FLOW = "flow"

        fun with(flow: String): Bundle {
            return bundleOf(FLOW to flow)
        }
    }
}
