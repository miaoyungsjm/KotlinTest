package com.example.c2_basics

import java.util.*

/**
 * @author ggz
 * @date 2020/7/23
 */
class Rectangle(
    val width: Int,
    val height: Int
) {
    val isSquare: Boolean
        get() {     // 自定义访问器
            return width == height
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(10), random.nextInt(10));
}