package com.deividasstr.oldhost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.deividasstr.base.BaseFragment
import com.deividasstr.base.HasViewInjector
import com.deividasstr.plugin.pluginactions.ui.PluginViewCapability
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import kotlinx.coroutines.launch
import javax.inject.Inject

class OldHostFragment : BaseFragment(), HasViewInjector {

    @Inject
    lateinit var viewInjector: DispatchingAndroidInjector<View>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: OldHostViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_host_old, container, false)
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

    override fun viewInjector(): AndroidInjector<View> {
        return viewInjector
    }
}
