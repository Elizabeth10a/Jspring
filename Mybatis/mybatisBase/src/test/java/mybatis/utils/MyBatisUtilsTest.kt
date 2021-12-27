package mybatis.utils

import mybatis.module.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/23/21
 * @Software: IntelliJ IDEA
 */
internal class MyBatisUtilsTest {
    var mb: MyBatisUtils = MyBatisUtils()


    @Test
    fun closeSqlSession() {
    }


    @Test
    fun getSqlSession() {
    }

    @Test
    fun getUsers() {
//       指定要执行的sql语句的标识。 sql映射文件中的namespace + "." + 标签的id值
        val sqlId = "mybatis.Base.domain.UserDal.getAllUser"
        mb.getSqlSession()


    }

    @Test
    fun addUser() {
        val sqlId = "mybatis.Base.domain.UserDal.addUser"
        val sqlSession = mb.getSqlSession()
        val insert = sqlSession?.insert(
            sqlId, User(4, "e", "e")
        ).let {
            println(it)
        }
        sqlSession?.commit()//手动提交事务
        sqlSession?.close()//保证线程安全


    }
}