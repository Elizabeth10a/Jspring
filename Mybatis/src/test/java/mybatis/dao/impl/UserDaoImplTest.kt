package mybatis.dao.impl

import mybatis.dao.QueryFrom
import mybatis.module.User
import org.apache.ibatis.annotations.Param
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

    @Test
    fun getAllUserById() {
        println(UserDaoImpl().getAllUserById(1))
    }


    @Test
    fun getAllUserBySql() {
        //隐患 sql注入 一般用来替换列名  表名 等安全的数据
        var sql: String = "'a'"
        sql += ";INSERT INTO Mybatis.m_user (id, name, pwd) VALUES (3, 'b', 'sd');"

        println(UserDaoImpl().getAllUserBySql(sql))

    }

    @Test
    fun getAllUserBySome1() {
        println(
            UserDaoImpl().getAllUserBySome1(0, "dd")
        )

    }

    @Test
    fun getAllUserByObject() {
        println(
            UserDaoImpl().getAllUserByObject(QueryFrom("a", "a"))
        )
    }

    @Test
    fun getAllUserByPosition() {
        println(
            UserDaoImpl().getAllUserByPosition("dd", "sd")
        )
    }

    @Test
    fun getAllUserByMap() {
//        val map = mapOf("ks" to 12, "as" to 12, "sas" to 34)
//        val mapOf = mapOf(Pair("as", 78))
        println(
            UserDaoImpl().getAllUserByMap(mapOf("name" to "a", "psw" to "sd"))

        )
    }

    @Test
    fun getUserCount() {
        println("---------")
        println(UserDaoImpl().getUserCount())
    }

    @Test
    fun getUserMapByName() {
        println("---------")
        println(UserDaoImpl().getUserMapByName("a")?.keys)
        println(UserDaoImpl().getUserMapByName("a")?.values)
    }

    @Test
    fun getAllUserMapByName() {
        println("---------")
        UserDaoImpl().getAllUserMapByName("a")?.forEach { it ->
            println(it)

        }
    }

    @Test
    fun getUserInfoByNameLike() {
        UserDaoImpl().getUserInfoByNameLike("%a%")?.forEach { it ->
            println(it)

        }
    }

    @Test
    fun getUserInfoByNameLike2() {
        UserDaoImpl().getUserInfoByNameLike("a")?.forEach { it ->
            println(it)

        }

    }

    @Test
    fun getAllUserByObjectIf() {

        UserDaoImpl().getAllUserByObjectIf(User(4, "a"))?.forEach { it ->
            println(it)
        }

    }

    @Test
    fun getAllUserByObjectWh() {
        UserDaoImpl().getAllUserByObjectWh(User(4, "a"))?.forEach { it ->
            println(it)
        }

    }

    @Test
    fun getAllUserByObjectEach() {
        UserDaoImpl().getAllUserByObjectEach(listOf(1, 2, 3))?.forEach { it ->
            println(it)
        }

    }

    @Test
    fun getAllUserByObjectEachObject() {
        val listOf = listOf<User>(User(1, "AS"), User(2, "as"))
        UserDaoImpl().getAllUserByObjectEachObject(listOf)?.forEach { it ->
            println(it)
        }

    }

}

