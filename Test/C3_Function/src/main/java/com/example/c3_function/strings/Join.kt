//@file:JvmName("StringFunctions")
// 注解指定类名
// 包的声明跟在文件注解之后
package com.example.c3_function.strings

/**
 * @author ggz
 * @date 2020/7/27
 */

// 顶层属性
// public static final String UNIX_LINE_SEPARATOR = "\n";
const val UNIX_LINE_SEPARATOR = "\n"

// 顶层函数
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",   // 有默认值的参数
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.myJoinToString(
    separator: String = ", ",   // 有默认值的参数
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// 扩展函数
// String - 接收者类型
// this   - 接收者对象
fun String.lastChar(): Char = this.get(length - 1)

// 扩展属性
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

