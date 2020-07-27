package com.example.c3_function.strings

/**
 * @author ggz
 * @date 2020/7/27
 */
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val filename = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("dir: $directory, name: $filename, ext: $extension")
}

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("dir: $directory, name: $filename, ext: $extension")
    }
}