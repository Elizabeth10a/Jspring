package com.eliza.sprioc.spribatis.service.impl

import com.eliza.sprioc.spribatis.dao.UserDao
import com.eliza.sprioc.spribatis.domain.User
import com.eliza.sprioc.spribatis.service.UserService
import com.eliza.sprioc.spribatis.utils.UseSpring
import org.apache.ibatis.session.SqlSessionFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("userService")
class UserServiceImpl : UserService {
    lateinit var ud: UserDao

    fun setUserDao(ud: UserDao) {
        this.ud = ud
    }

    override fun addUser(user: User): Int? {
        /*
             val sqlSessionFactory = UseSpring().getObject("sqlSessionFactory") as SqlSessionFactory
             val sqlSession = sqlSessionFactory.openSession(true)
             val selectList = sqlSession?.getMapper(UserDao::class.java)?.addUser(user)
             sqlSession?.close()
             return selectList
        */
        return ud.addUser(user)
    }

    override fun getUser(): List<User> {
        return ud.getAllUser()
    }

}