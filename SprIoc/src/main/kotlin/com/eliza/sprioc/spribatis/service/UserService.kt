package com.eliza.sprioc.spribatis.service

import com.eliza.sprioc.spribatis.domain.User


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */

//业务层，处理信息，并调用数据库方法
interface UserService {
    fun addUser(user: User): Int?
    fun getUser(): List<User>
}
