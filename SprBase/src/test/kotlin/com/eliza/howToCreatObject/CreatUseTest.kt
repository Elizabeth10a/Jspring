package com.eliza.howToCreatObject

import com.eliza.howToCreatObject.model.User
import org.junit.jupiter.api.Test

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/4/22
 * @Software: IntelliJ IDEA
 */
internal class CreatUseTest {
    var cu: UseSpring = UseSpring()


    @Test
    fun getSpringInfo() {
        cu.getSpringInfo()
    }

    @Test
    fun getUserWithSet() {
        var user = cu.useSpring("user") as User
        println(user.toString())

        //set 简单注入
        user = cu.useSpring("ssUser") as User
        println(user.toString())

        //set 引用注入
        user = cu.useSpring("sqUser") as User
        println(user.toString())

    }

    @Test
    fun getUserWithConstruction() {
        //构造 引用注入
        var user = cu.useSpring("structUserWithName") as User
        println(user.toString())

        //构造 引用注入
        user = cu.useSpring("structUserWithIndex") as User
        println(user.toString())

        //构造 引用注入
        user = cu.useSpring("userByName") as User
        println(user.toString())
    }

    @Test
    fun getUserWithAutowire() {
        cu = UseSpring("howToCreatObject/BeanAutowire/QuoteBeans.xml")
//        引用类型
        //构造 引用注入
        var user = cu.useSpring("userByName") as User
        println(user.toString())

    }
}