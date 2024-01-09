package com.deividasstr.base

import javax.inject.Scope
import kotlin.reflect.KClass

abstract class ActivityScope private constructor()
abstract class ApplicationScope private constructor()
abstract class FragmentScope private constructor()
abstract class FragmentChildScope private constructor()

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val value: KClass<*>)