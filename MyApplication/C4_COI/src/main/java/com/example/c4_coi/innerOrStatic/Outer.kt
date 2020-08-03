package com.example.c4_coi.innerOrStatic

/**
 * @author ggz
 * @date 2020/7/29
 */
class Outer {
    inner class Inner {
        // 内部类访问外部类
        fun getOutReference(): Outer = this@Outer
    }
}