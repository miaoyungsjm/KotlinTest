package com.example.c2_basics

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

/**
 * @author ggz
 * @date 2020/7/22
 */
//class Client {
//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            println("Hello, World!")
//
//        }
//    }
//}

// 代码块体函数
fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// 表达式体函数
fun max2(a: Int, b: Int): Int = if (a > b) a else b

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Fizz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "Digit"
    in 'a'..'z', in 'A'..'Z' -> "Letter"
    else -> "Unknown"
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {      // 把 try - catch 作为表达式
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        e.printStackTrace()
        null
    } finally {
        reader.close()
    }
    println("result: $number")
}

fun main(args: Array<String>) {
    println("Hello, World!")

    println("-----------------------")
    // fun 关键字用来声明函数
    println(max1(1, 2))
    // if 现在是带返回值的表达式
    println(max2(3, 4))

    println("-----------------------")
    // val 不可变引用
    val question = "1 + 1 ="    // 类型推导
    val answer: Int = 2
    println("$question $answer")
    // var 可变引用
    var v = 99  // 编译器只会根据初始化器来推断变量类型，变量类型改变需强制转换
    v = 100
    println("$v")   // 字符串模板 $

    // 引用自身是不可变的，但它指向的对象可能是可变的
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    languages.add("C")
    println("$languages")

    println("-----------------------")
    // is 的 getter，setter 函数
    val person = Person("Bob", true)
    person.isMarried = false
    println("${person.name} isMarried: ${person.isMarried}")

    println("-----------------------")
    // 自定义访问器，导入包
//    val rectangle = Rectangle(7, 7)
    val rectangle = createRandomRectangle()
    println(
        "rectangle width: ${rectangle.width} height: ${rectangle.height} " +
                "isSquare: ${rectangle.isSquare}"
    )

    println("-----------------------")
    // 枚举类，when
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.BLUE))
    println(mix(Color.BLUE, Color.YELLOW))

    println("-----------------------")
    // 智能转换：合并类型检查和转换
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))

    println("-----------------------")
    // 循环 for
    for (i in 1..20) {      // [1,20]
        print(fizzBuzz(i) + " ")
    }
    println()
    for (i in 20 downTo 1 step 2) {
        print(fizzBuzz(i) + " ")
    }
    println()

    println("-----------------------")
    val binaryReps = TreeMap<Char, String>()    //  使用 TreeMap 让键自动排序
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary                  // map[key] = value
    }
    for ((letter, binary) in binaryReps) {
        println("$letter: $binary")
    }

    println("-----------------------")
    // withIndex 迭代集合时使用下标
    val list1 = arrayListOf("0", "01", "10", "1001")
    for ((index, element) in list1.withIndex()) {
        println("$index: $element")
    }

    println("-----------------------")
    // in  !in
    println(isLetter('k'))
    println(isNotDigit('b'))
    println(recognize('8'))

    println("-----------------------")
    // 异常
//    val number = 101
//    val percentage =
//        if (number in 0..100)
//            number
//        else
//            throw IllegalArgumentException(     // "throw" 也是一个表达式
//                "A percentage value must be between 0 to 100: $number"
//            )

    val reader = BufferedReader(StringReader("123"))
    println(readNumber(reader))
    val reader2 = BufferedReader(StringReader("not a number"))
    readNumber2(reader2)
}


