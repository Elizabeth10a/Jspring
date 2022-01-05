package mybatis.dao.impl

import mybatis.dao.QueryFrom
import mybatis.dao.UserDao
import mybatis.module.User
import mybatis.utils.MyBatisUtils


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/23/21
 * @Software: IntelliJ IDEA
 */
class UserDaoImpl : UserDao {


    override fun addUser(user: User): Int? {
        val sqlId = "mybatis.dao.UserDao.addUser"
        val sqlSession = MyBatisUtils().getSqlSession()

        val insert = sqlSession?.insert(
            sqlId, user
        )
        sqlSession?.close()//保证线程安全
        return insert
    }

    override fun getAllUser(): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val sqlId = "mybatis.dao.UserDao.getAllUser"
        val selectList = sqlSession?.selectList<User>(sqlId)
        sqlSession?.close()
        return selectList as List<User>

    }

    override fun getAllUserById(id: Int): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserById(id)
        sqlSession?.close()
        return selectList as List<User>
    }

    override fun getAllUserBySql(name: String): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserBySql(name)
        sqlSession?.close()
        return selectList as List<User>
    }

    override fun getAllUserBySome1(id: Int, name: String): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserBySome1(id, name)


        sqlSession?.close()
        return selectList as List<User>

    }

    override fun getAllUserByObject(qt: QueryFrom): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByObject(qt)
        sqlSession?.close()
        return selectList as List<User>

    }

    override fun getAllUserByPosition(name: String, pwd: String): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByPosition(name, pwd)
        sqlSession?.close()
        return selectList as List<User>


    }

    override fun getAllUserByMap(map: Map<String, Any>): List<User> {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByMap(map)
        sqlSession?.close()
        return selectList as List<User>
    }


    override fun getUserCount(): Int? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getUserCount()
        sqlSession?.close()
        return selectList
    }

    override fun getUserMapByName(name: String): Map<String, Any>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getUserMapByName(name)
        sqlSession?.close()
        return selectList
    }

    override fun getAllUserMapByName(name: String): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserMapByName(name)
        sqlSession?.close()
        return selectList
    }

    //模糊查询 推荐
    override fun getUserInfoByNameLike(name: String): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
//        模糊字->  %撒%
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getUserInfoByNameLike(name)
        sqlSession?.close()
        return selectList
    }

    override fun getUserInfoByNameLike2(name: String): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
//        模糊字->  撒；%拼接在  配置文件中
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getUserInfoByNameLike(name)
        sqlSession?.close()
        return selectList
    }

    override fun getAllUserByObjectIf(user: User): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByObjectIf(user)
        sqlSession?.close()
        return selectList
    }

    override fun getAllUserByObjectWh(user: User): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByObjectWh(user)
        sqlSession?.close()
        return selectList
    }

    override fun getAllUserByObjectEach(list: List<Int>): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByObjectEach(list)
        sqlSession?.close()
        return selectList
    }

    override fun getAllUserByObjectEachObject(list: List<User>): List<User>? {
        val sqlSession = MyBatisUtils().getSqlSession()
        val selectList = sqlSession?.getMapper(UserDao::class.java)?.getAllUserByObjectEachObject(list)
        sqlSession?.close()
        return selectList
    }


}