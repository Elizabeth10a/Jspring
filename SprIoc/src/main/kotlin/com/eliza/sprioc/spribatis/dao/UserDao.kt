package com.eliza.sprioc.spribatis.dao

import com.eliza.sprioc.spribatis.domain.User
import org.apache.ibatis.annotations.Param


interface UserDao {
    fun addUser(user: User): Int
    fun getAllUser(): List<User>


}