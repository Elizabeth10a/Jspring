package mybatis.dao

import mybatis.module.User


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/21/21
 * @Software: IntelliJ IDEA
 */

//有没有都行
interface UserDao {

    fun getAllUser(): List<User>

    /**
     * Add user
     *
     * @param user
     * @return 影响数据库的行数
     */
    fun addUser(user: User): Int?


}