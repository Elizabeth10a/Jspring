package mybatis.dao.impl

import mybatis.module.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/23/21
 * @Software: IntelliJ IDEA
 */
internal class UserDaoImplTest {

    @Test
    fun getAllUser() {

        for (v in UserDaoImpl().getAllUser()) {
            println(v)
        }
    }

    @Test


    fun addUser() {
        println(UserDaoImpl().addUser(User(13, "as", "as")))



    }
}