package com.example.c3_function.strings

import java.lang.IllegalArgumentException

/**
 * @author ggz
 * @date 2020/7/27
 */
class User(val id: Int, val name: String, val address: String)

fun saveUser1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty address")
    }
    // 保存数据库
}

// 局部函数
fun saveUser2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {    // 声明一个局部函数来验证字段
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "name")
    validate(user, user.address, "address")
    println("保存数据库")
}

fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String) {    // 省略参数 user
        if (value.isEmpty()) {
            // 局部函数可以访问所在函数中的所有参数和变量 - user.id
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user.name, "name")
    validate(user.address, "address")
    println("保存数据库")
}

// 扩展函数
fun saveUser4(user: User) {
    user.validateBeforeSave()
    println("保存数据库")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            // 扩展函数可以直接访问 User 的属性 - id
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }
    validate(name, "name")
    validate(address, "address")
}