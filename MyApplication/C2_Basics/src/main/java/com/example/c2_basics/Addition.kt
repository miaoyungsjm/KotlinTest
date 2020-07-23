package com.example.c2_basics

import java.lang.IllegalArgumentException

/**
 * @author ggz
 * @date 2020/7/23
 */
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {         // 检查类型
        val n = e as Num    // 手动类型转换
        return n.value      // 其实可以直接 e.value
    }
    if (e is Sum) {         // 其实检查后，编译器已自动完成类型转换(智能转换)
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            eval2(e.left) + eval2(e.right)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

fun eval3(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value         // 代码块最后的表达式就是结果
        }
        is Sum -> {
            val left = eval3(e.left)
            val right = eval3(e.right)
            println("sum: $left + $right")
            left + right
        }
        else ->
            throw IllegalArgumentException("Unknown expression")
    }