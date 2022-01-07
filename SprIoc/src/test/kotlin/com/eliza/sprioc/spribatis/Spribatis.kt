package com.eliza.sprioc.spribatis

import com.eliza.sprioc.affairsHandle.dao.GoodsDao
import com.eliza.sprioc.spribatis.dao.UserDao
import com.eliza.sprioc.spribatis.domain.User
import com.eliza.sprioc.spribatis.service.impl.BuyGoodsServiceImpl
import com.eliza.sprioc.spribatis.service.impl.UserServiceImpl
import com.eliza.sprioc.spribatis.utils.UseSpring
import org.junit.jupiter.api.Test


internal class spribatis {
    var us: UseSpring = UseSpring()


    @Test
    fun getInfo() {
        us.getInfo()

    }


    @Test
    fun getUser() {
        val user = us.getObject("user") as User
        println(user.toString())
    }

    @Test
    fun getUserDao() {
        var userDao = us.getObject("userDao") as UserDao
        userDao.addUser(User(11, "as", "as"))
    }

    @Test
    fun userServiceImpl() {
        var userService = us.getObject("userService") as UserServiceImpl
        userService.setUserDao(us.getObject("userDao") as UserDao)
        userService.addUser(User(10, "as", "as"))
    }

    @Test
    fun affairsService() {
        var affairsService = us.getObject("buyGoodsService") as BuyGoodsServiceImpl
        affairsService.setGoodsDao(us.getObject("goodsDao") as GoodsDao)
    }
}