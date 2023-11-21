package com.deividasstr.base

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplicationScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CheckoutPluginScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val value: KClass<*>)