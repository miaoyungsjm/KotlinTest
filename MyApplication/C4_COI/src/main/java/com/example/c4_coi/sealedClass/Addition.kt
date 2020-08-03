package com.example.c4_coi.sealedClass

import java.lang.IllegalArgumentException

/**
 * @author ggz
 * @date 2020/7/23
 */
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num ->
            e.value
        is Expr.Sum ->
            eval(e.left) + eval(e.right)
    }

/*
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            eval(e.left) + eval(e.right)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }
*/
