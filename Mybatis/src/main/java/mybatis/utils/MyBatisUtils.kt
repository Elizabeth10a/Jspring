package mybatis.utils

import mybatis.module.User
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/21/21
 * @Software: IntelliJ IDEA
 */
class MyBatisUtils {


    private var factory: SqlSessionFactory
    private var config: String = "mybatis/mybatis.xml" // 需要和你的项目中的文件名一样

    init {
        val inputStream = Resources.getResourceAsStream(config)
        factory = SqlSessionFactoryBuilder().build(inputStream)
    }

    fun getSqlSession(): SqlSession? {
        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        return factory.openSession(true)
        //定义数据库操作的方法
    }



    fun closeSqlSession() {
        factory.openSession().close()
    }


}