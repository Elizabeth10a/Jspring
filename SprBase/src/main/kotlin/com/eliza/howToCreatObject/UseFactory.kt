package com.eliza.howToCreatObject

import com.eliza.howToCreatObject.model.User
import java.util.*
import kotlin.collections.HashMap


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/4/22
 * @Software: IntelliJ IDEA
 */


class UseFactory {

    /**
     * 一个创建Bean对象的工厂
     *
     * Bean：在计算机英语中，有可重用组件的含义。
     * JavaBean：用java语言编写的可重用组件。
     *      javabean >  实体类
     *
     *   它就是创建我们的service和dao对象的。
     *
     *   第一个：需要一个配置文件来配置我们的service和dao
     *           配置的内容：唯一标识=全限定类名（key=value)
     *   第二个：通过读取配置文件中配置的内容，反射创建对象
     *
     *   我的配置文件可以是xml也可以是properties
     */
    val beans = HashMap<String, Any>()
    val pro = Properties()

    init {

        var beanPath = "howToCreatObject/bean.properties"
        val inputStream = UseFactory::class.java.classLoader.getResourceAsStream(beanPath)
        pro.load(inputStream)
    }

    fun justTradition(): User {
        return User("name", 12)
    }

    fun getObjWithBean(obj: String): Any? {
        beans[obj]?.let { return beans[obj] as Any }
        return null

    }
}
