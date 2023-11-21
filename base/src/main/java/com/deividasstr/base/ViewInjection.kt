package com.deividasstr.base

import android.app.Activity
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment

object ViewInjection {

    fun inject(view: View) {
        val activity = view.getActivity()
        if (activity !is HasViewInjector) {
            val activityName = activity.javaClass.canonicalName
            val injectorName = HasViewInjector::class.java.canonicalName
            throw ViewInjectionException("$activityName} does not implement $injectorName")
        }

        (activity as HasViewInjector).viewInjector().inject(view)
    }

    private fun View.getActivity(): Activity {
        var ctx = context
        while (ctx is ContextWrapper) {
            if (ctx is Activity) {
                return ctx
            }
            ctx = ctx.baseContext
        }

        throw ViewInjectionException("Context does not stem from an activity: $context")
    }

    fun injectFragment(view: View) {
        val fragment = view.findFragment<Fragment>()
        if (fragment !is HasViewInjector) {
            val fragmentName = fragment.javaClass.canonicalName
            val injectorName = HasViewInjector::class.java.canonicalName
            throw ViewInjectionException("$fragmentName} does not implement $injectorName")
        }

        (fragment as HasViewInjector).viewInjector().inject(view)
    }

    class ViewInjectionException(message: String) : RuntimeException(message)
}
