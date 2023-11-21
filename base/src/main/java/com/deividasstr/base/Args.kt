package com.deividasstr.base

import androidx.fragment.app.Fragment

/**
 * This class is the only way to use [VintedFragmentCreator].
 * First, you must declare `companion object` of Fragment:
 *
 * Example:
 * ```
 *  class Foo : Fragment() {
 *      companion object : Args<Foo> {
 *          fun with(a: Int) = argsOf(
 *              "A" to a
 *          )
 *
 *          fun with(a: Int, b: Boolean) = argsOf(
 *              "A" to a,
 *              "B" to b
 *          )
 *      }
 *  }
 * ```
 */
interface Args<@Suppress("unused") F : Fragment>
