package com.example.c4_coi.obj

import java.io.File

/**
 * @author ggz
 * @date 2020/7/31
 *
 * object 关键字，定一个类并同时创建一个实例
 * 使用场景：
 * 1、对象声明，定义单例的一种方式
 * 2、伴生对象，可以持有工厂方法和其他与这个类相关，
 * 但在调用时并不依赖实例的方法。它们的成员可以通过类名来访问
 * 3、对象表达式，用来替代 Java 的匿名内部类
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}