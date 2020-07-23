package com.example.c2_basics

import java.lang.Exception

/**
 * @author ggz
 * @date 2020/7/23
 */
enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    // 枚举常量
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);  // 用 ; 把枚举常量列表和方法定义分离

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }

// setOf 函数可以创建一个 set 对象，只要包含一样条目，不分顺序，它们就是相等
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

// 没有给 when 表达式提供参数，分之条件就是任意 boolean 表达式
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }