package com.example.c2_basics

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

fun main(args: Array<String>) {
    println("Hello, World!")
    println(max1(1, 2))
    println(max2(3, 4))

    // 不可变引用
    val question = "1 + 1 ="    // 类型推导
    val answer: Int = 2
    println("$question $answer")
    // 可变引用
    var v = 99  // 编译器只会根据初始化器来推断变量类型，变量类型改变需强制转换
    v = 100
    println("$v")

    // 引用自身是不可变的，但它指向的对象可能是可变的
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    languages.add("C")
    println("$languages")

    // getter，setter
    val person = Person("Bob", true)
    person.isMarried = false
    println("${person.name} isMarried: ${person.isMarried}")

    // 自定义访问器，导入包
//    val rectangle = Rectangle(7, 7)
    val rectangle = createRandomRectangle()
    println(
        "rectangle width: ${rectangle.width} height: ${rectangle.height} " +
                "isSquare: ${rectangle.isSquare}"
    )

    // 枚举类，when
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.BLUE))
    println(mix(Color.BLUE, Color.YELLOW))

    // 智能转换：合并类型检查和转换
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
}


