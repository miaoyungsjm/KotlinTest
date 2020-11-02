package com.example.c4_coi.obj

import com.example.c4_coi.interfaceProperties.getFacebookName

/**
 * @author ggz
 * @date 2020/8/3
 */
class User private constructor(val nickname: String) {

    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))
    }
}