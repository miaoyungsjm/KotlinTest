package com.example.c3_function

import com.example.c3_function.rewrite.Button
import com.example.c3_function.rewrite.View
import com.example.c3_function.rewrite.showOff
import com.example.c3_function.strings.*

// 导入扩展函数，关键字 as 修改导入的类或函数名
import java.lang.StringBuilder

/**
 * @author ggz
 * @date 2020/7/27
 */
fun main(args: Array<String>) {
    println("-----------------------")
    // 集合类，在 java 的基础上提供更丰富的 API
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    // 获取列表最后一个元素
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    // 获取数字列表最大值
    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    println("-----------------------")
    val list1 = listOf(1, 2, 3)
    println(list1)
    // 顶层函数，工具类的静态方法
    println(joinToString(list1, "; ", "(", ")"))
    // 命名参数，显示地标明一些参数的名称
    println(joinToString(list1, separator = "; ", prefix = "(", postfix = ")"))

    println("-----------------------")
    // 给参数提供默认值，降低重载函数的必要性
    println(joinToString(list1))
    // 可以省略末尾参数
    println(joinToString(list1, "; "))
    // 命名参数，可以省略中间参数及任意顺序
    println(joinToString(list1, postfix = "", prefix = "# "))

    println("-----------------------")
    // 扩展函数，它是定义在类外面的成员函数，可以和类内方法一样正常访问。
    // 它可以直接访问共有的成员，但不能访问私有的或受保护的成员
    println("Kotlin".lastChar())
    println(list1.myJoinToString(separator = "; ", prefix = "(", postfix = ")"))

    println("-----------------------")
    // 扩展函数不存在重写
    val view: View = Button()
    view.click()
    view.showOff()

    println("-----------------------")
    // 扩展属性
    println("Kotlin".lastChar)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    println("-----------------------")
    // vararg 可变参数: 让函数支持任意数量的参数
    // * 展开运算符，解包数组
    val list2 = listOf("args: ", *args)
    println(list2)

    println("-----------------------")
    // 中缀调用，1 to "one" 返回一个 Pair 对象
    val pair1: Pair<Int, String> = 1 to "one"
    println(pair1)

    println("-----------------------")
    // 分割字符串
    println("12.345-6.A".split("\\.|-".toRegex()))  // 转为正则表达式
    println("12.345-6.A".split(".", "-"))
    parsePath("/Users/ggz/kotlin/chapter.adoc")
    parsePathRegex("/Users/ggz/kotlin/chapter.adoc")

    println("-----------------------")
    // 三重引号
    val kotlinLogo = """| //
                       .|//
                       .|/  \"""
    // trimMargin 删除前缀和前面的空格
    println(kotlinLogo.trimMargin("."))

    println("-----------------------")
    // 局部函数和扩展
//    saveUser3(User(1, "", ""))
    saveUser4(User(1, "", ""))
}