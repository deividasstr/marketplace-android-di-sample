package com.deividasstr.paymentplugin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.deividasstr.base.ViewInjection
import com.deividasstr.paymentplugin.databinding.ViewPluginPaymentBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentPluginView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: PaymentPluginViewModel

    private val binding = ViewPluginPaymentBinding.inflate(LayoutInflater.from(context), this, true)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ViewInjection.injectFragment(this)

        viewModel = requireNotNull(findViewTreeViewModelStoreOwner()) {
            "Unknown ViewModelStoreOwner for this view: $this"
        }.let { viewModelStoreOwner ->
            ViewModelProvider(viewModelStoreOwner, viewModelFactory).get()
        }
        findViewTreeLifecycleOwner()?.let { lifecycleOwner ->
            with(lifecycleOwner) {
                lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.state.collect(::handleState)
                    }
                }
            }
        }
    }

    private fun handleState(state: PaymentPluginState) {
        binding.paymentPluginText.text = state.state
    }
}
