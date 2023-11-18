package com.deividasstr.plugin.pluginactions.progress

import kotlinx.coroutines.flow.StateFlow

interface ProgressProvider {
    val isInProgress: StateFlow<Boolean>
}
