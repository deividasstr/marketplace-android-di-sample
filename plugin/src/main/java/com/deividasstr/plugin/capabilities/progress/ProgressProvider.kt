package com.deividasstr.plugin.capabilities.progress

import kotlinx.coroutines.flow.StateFlow

interface ProgressProvider {
    val isInProgress: StateFlow<Boolean>
}
