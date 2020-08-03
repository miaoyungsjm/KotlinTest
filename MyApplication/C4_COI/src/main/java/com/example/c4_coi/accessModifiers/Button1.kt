package com.example.c4_coi.accessModifiers

/**
 * @author ggz
 * @date 2020/7/28
 */
class Button1 : Clickable, Focusable {
    override fun click() = println("clicked")

    override fun showOff() {    // 不止一个实现，必须提供一个显示实现
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}