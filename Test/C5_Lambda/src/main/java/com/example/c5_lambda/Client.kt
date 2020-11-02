package com.example.c5_lambda

import android.net.IpPrefix

/**
 * @author ggz
 * @date 2020/8/4
 */
data class Person(val name: String, val age: Int)

fun Person.isAdult() = age >= 18

class Book(val title: String, val authors: List<String>)

fun printMessagesWithPrefix(message: Collection<String>, prefix: String) {
    var count = 0
    message.forEach {
        // lambda 捕捉 prefix、count
        // kotlin 允许在 lambda 内部访问非 final 变量甚至修改它们
        println("$prefix $it")
        count++
    }
    println("message count: $count")
}

fun salute() = println("salute")

fun sendEmail(person: Person, message: String) =
    println("${person.name} $message")

fun main(args: Array<String>) {

    println("-----------------------")
    // 声明到一个变量中
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))

    println("-----------------------")
    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Carol", 31),
        Person("Cindy", 24),
        Person("Tifa", 24)
    )
    // 可以把它当作值到处传递
    println(people.maxBy { it.age })
    // 演变过程
//    people.maxBy({ p: Person -> p.age })
//    people.maxBy() { p: Person -> p.age }
//    people.maxBy { p: Person -> p.age }
//    people.maxBy { p -> p.age }
//    people.maxBy { it.age }

    println("-----------------------")
    val names = people.joinToString(separator = " ",
        transform = { p: Person -> p.name })
//    people.joinToString(" ") { p: Person -> p.name }
//    people.joinToString(" ") { p -> p.name }
//    people.joinToString(" ") { it.name }
    println(names)

    println("-----------------------")
    // lambda 捕捉，可引这个函数的参数和局部变量
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error: ")

    println("-----------------------")
    // 成员引用
    val getAge1 = Person::age
    val getAge2 = { person: Person -> person.age }
    // 引用顶层函数
    run(::salute)
    // 解决已有函数定义相同的功能，无需把调用放进 lambda 里
    val cindy = Person("Cindy", 24)
    val action = { person: Person, message: String ->
        sendEmail(person, message)
    }
    val nextAction = ::sendEmail
    nextAction(cindy, "pretty girl")
    // 引用构造函数
    val createPerson = ::Person
    println(createPerson("Tifa", 24))
    // 引用扩展函数
    val predicate = Person::isAdult
    println(predicate(cindy))

    // 集合函数 API
    println("-----------------------")
    // filter 可以从集合中移除你不想要的元素，但是它不会改变这些元素
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(people.filter { it.age > 30 })

    // map 元素变换
    // 对集合中的每一个元素应用给定的函数并把结果收集到一个新集合
    println(list.map { it * it })
    println(people.map { it.name })
    println(people.map(Person::name))

    println(people.filter { it.age > 30 }.map { it.name })
    val maxAge = people.maxBy(Person::age)!!.age
    println(people.filter { it.age == maxAge })

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    // 对集合应用判断式
    println("-----------------------")
    // all 检查集合中的所有元素是否都符合某个条件
    println(people.all { it.age >= 30 })
    // any 检查集合中的所有元素是否存在一个符合条件
    println(people.any { it.age >= 30 })
    // count 检查有多少元素满足判断式
    println(people.count { it.age >= 30 })
    // find/firstOrNull 返回第一个符合条件的元素
    println(people.find { it.age >= 30 })

    // 把列表转换成分组的 map
    println("-----------------------")
    // 生成 map
    println(people.groupBy { it.age })

    // 处理嵌套集合中的元素
    println("-----------------------")
    val books = listOf(
        Book("Thursday Next", listOf("Jasper Forde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )
    println(books.flatMap { it.authors }.toSet())

    val strings = listOf("abc", "efg")
    strings.flatMap { it.toList() }

    // 惰性集合
    println("-----------------------")
    // 序列

}