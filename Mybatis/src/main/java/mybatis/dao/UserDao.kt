package mybatis.dao

import mybatis.module.User
import org.apache.ibatis.annotations.Param


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/21/21
 * @Software: IntelliJ IDEA
 */

//有没有都行
interface UserDao {

    fun getAllUser(): List<User>
    fun getAllUserById(id: Int): List<User>
    fun getAllUserBySql(@Param("name") name: String): List<User>


    fun getAllUserBySome1(
        @Param("myId") id: Int,
        @Param("myName") name: String

    ): List<User>

    //对象传值
    fun getAllUserByObject(qt: QueryFrom): List<User>

    fun getAllUserByPosition(name: String, pwd: String): List<User>

    fun getAllUserByMap(map: Map<String, Any>): List<User>

    /**
     * Add user
     *
     * @param user
     * @return 影响数据库的行数
     */
    fun addUser(user: User): Int?
    fun getUserCount(): Int?

    //    返回map
    fun getUserMapByName(@Param("name") name: String): Map<String, Any>?
    fun getAllUserMapByName(@Param("name") name: String): List<User>?

    fun getUserInfoByNameLike(@Param("name") name: String): List<User>?
    fun getUserInfoByNameLike2(@Param("name") name: String): List<User>?


    fun getAllUserByObjectIf(user: User): List<User>?
    fun getAllUserByObjectWh(user: User): List<User>?
    fun getAllUserByObjectEach(list: List<Int>): List<User>?
    fun getAllUserByObjectEachObject(list: List<User>): List<User>?


}