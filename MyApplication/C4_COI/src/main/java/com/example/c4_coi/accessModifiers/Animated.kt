package com.example.c4_coi.accessModifiers

/**
 * @author ggz
 * @date 2020/7/28
 */
abstract class Animated {

    abstract fun animate()

    // 抽象类中的非抽象函数并不是默认 open 的，但是可以标注为 open 的
    open fun stopAnimating() {}
    fun animateTwice() {}
}