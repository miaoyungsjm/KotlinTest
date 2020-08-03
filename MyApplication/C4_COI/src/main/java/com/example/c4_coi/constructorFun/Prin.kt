package com.example.c4_coi.constructorFun

/**
 * @author ggz
 * @date 2020/7/29
 */
//class User(val nickname: String)

class User constructor(nickname: String) {
    val nickname: String

    init {
        this.nickname = nickname
    }
}

// 私有构造方法，关联伴生对象
class Secretive private constructor() {}

