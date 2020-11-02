package com.example.c4_coi.interfaceProperties

/**
 * @author ggz
 * @date 2020/7/30
 */
// 主构造方法属性
class PrivateUser(override val nickname: String) : User

// 自定义 getter
class SubscribingUser(val email: String) : User {
    // 没有一个支持字段来存储它的值，它只有一个 getter 在每次调用时从 email 中截取
    override val nickname: String
        get() = email.substringBefore('@')
}

fun getFacebookName(accountId: Int): String {
    // 网络请求
    return accountId.toString()
}

class FacebookUser(val accountId: Int) : User {
    // FacebookUser 中的属性有一个支持字段来存储在类初始化时计算得到的数据
    override val nickname = getFacebookName(accountId)

    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $accountId: 
                "$field" -> "$value".""".trimIndent()
            )
            // 特殊的标识符 field 来访问支持字段
            field = value
        }
}

