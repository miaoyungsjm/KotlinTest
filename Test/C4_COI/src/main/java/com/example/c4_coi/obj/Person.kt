package com.example.c4_coi.obj

/**
 * @author ggz
 * @date 2020/8/3
 */
data class Person(val name: String) {

    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int =
            o1.name.compareTo(o2.name)
    }
}