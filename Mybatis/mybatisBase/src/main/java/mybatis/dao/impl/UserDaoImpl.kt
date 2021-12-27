package mybatis.dao.impl

import mybatis.dao.UserDao
import mybatis.module.User
import mybatis.utils.MyBatisUtils


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/23/21
 * @Software: IntelliJ IDEA
 */
class UserDaoImpl : UserDao {
    override fun getAllUser(): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        var sqlId = "mybatis.dao.UserDao.getAllUser"
        val selectList = sqlSession?.selectList<User>(sqlId)
        sqlSession?.close()
        return selectList as List<User>

    }

    override fun addUser(user: User): Int? {
        val sqlId = "mybatis.dao.UserDao.addUser"
        val sqlSession = MyBatisUtils().getSqlSession()

        val insert = sqlSession?.insert(
            sqlId, user
        )
        sqlSession?.close()//保证线程安全
        return insert
    }
}