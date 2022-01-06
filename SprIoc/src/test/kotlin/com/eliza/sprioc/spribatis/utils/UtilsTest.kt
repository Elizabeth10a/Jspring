package com.eliza.sprioc.spribatis.utils

import com.eliza.sprioc.spribatis.dao.UserDao
import com.eliza.sprioc.spribatis.domain.User
import com.eliza.sprioc.spribatis.service.impl.UserServiceImpl
import org.junit.jupiter.api.Test


internal class UtilsTest {
    var us: UseSpring = UseSpring()


    @Test
    fun getInfo() {
        us.getInfo()

    }

    @Test
    fun getObject() {
        val user = us.getObject("user") as User
        println(user.toString())
    }

    @Test
    fun getUserDao() {
        val user = us.getObject("user") as User
        println(user.toString())
    }

    @Test
    fun getuserDao() {
        var userDao = us.getObject("userDao") as UserDao
        userDao.addUser(User(11, "as", "as"))
    }

    @Test
    fun userServiceImpl() {
        var userService = us.getObject("userService") as UserServiceImpl
        userService.setUserDao(us.getObject("userDao") as UserDao)
        userService.addUser(User(12, "as", "as"))
    }

    @Test
    fun getUser() {
        var userService = us.getObject("userService") as UserServiceImpl


        //也可以直接在 配置文件中定义 自动赋值的对象
        userService.setUserDao(us.getObject("userDao") as UserDao)
        userService.getUser().forEach { it ->
            println(it.toString())
        }
    }
}