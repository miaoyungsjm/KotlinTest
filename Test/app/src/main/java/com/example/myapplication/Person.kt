package com.example.myapplication

data class Person(var name: String, var age: Int?) {
    var introduce: String? = null
        get() {
            return "self-introduction: $field"
        }
    var isMarried: Boolean? = false
}
