package com.deividasstr.di

import javax.inject.Inject

class BaseDependency @Inject constructor() {

    fun doSomething(): String {
       return "Hello from BaseDependency $this"
    }
}