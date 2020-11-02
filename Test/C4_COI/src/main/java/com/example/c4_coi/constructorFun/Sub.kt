package com.example.c4_coi.constructorFun

/**
 * @author ggz
 * @date 2020/7/29
 */
open class View {
    // 从构造函数
    constructor(ctx: String) {
        println("View: 1")
    }

    constructor(ctx: String, attr: String) {
        println("View: 11")
    }
}

class Button3 : View {
     constructor(ctx: String) : super(ctx) {
        println("Button: 3")
    }

    constructor(ctx: String, attr: String) : super(ctx, attr) {
        println("Button: 33")
    }
}

class Button4 : View {
    constructor(ctx: String) : this(ctx, "MY_STYLE") {
        println("Button: 4")
    }

    constructor(ctx: String, attr: String) : super(ctx, attr) {
        println("Button: 44")
    }
}