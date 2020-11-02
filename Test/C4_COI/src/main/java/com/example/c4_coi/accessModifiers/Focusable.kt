package com.example.c4_coi.accessModifiers

/**
 * @author ggz
 * @date 2020/7/28
 */
interface Focusable {
    fun setFocus(b: Boolean) = println("${if (b) "got" else "lost"} focus")
    fun showOff() = println("Focusable")
}