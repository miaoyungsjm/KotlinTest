package com.example.c4_coi.accessModifiers

/**
 * @author ggz
 * @date 2020/7/28
 */
interface Clickable {   // 接口中的成员始终是 open 的
    fun click()
    fun showOff() = println("Clickable")    // 带默认实现
}