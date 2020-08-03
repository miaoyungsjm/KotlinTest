package com.example.c4_coi.accessModifiers

/**
 * @author ggz
 * @date 2020/7/28
 */
open class Button2 : Clickable {     // 这个类是 open 的，其他类可以继承它

    fun disable() {}        // 默认 final ，不能在子类中重写

    open fun animate() {}   // 这个函数是 open 的，可以在子类中重写它

    override fun click() {} // 重写了一个 open 函数，并且它本身也是 open 的
    // final override fun click() {}    // 禁止重写
}