package com.deividasstr.plugin

abstract class CheckoutPlugin: Plugin() {
    abstract val pluginType: CheckoutPluginType
}