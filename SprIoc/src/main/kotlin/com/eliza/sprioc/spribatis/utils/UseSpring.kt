package com.eliza.sprioc.spribatis.utils

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/5/22
 * @Software: IntelliJ IDEA
 */
class UseSpring {

    var config = "spring.xml"
    var ac: ApplicationContext = ClassPathXmlApplicationContext(config)

    constructor()

    constructor(config: String? = null) {
        config?.let { this.config = config }
    }

    fun getInfo() {
        println("配置文件中的对象数量: ${ac.beanDefinitionCount}")
        ac.beanDefinitionNames.forEach { it ->
            println("对象名称：${it}")
        }
    }

    fun getObject(obj: String): Any {
        //1.获取核心容器对象  此时创建配置文件中的对象
        return ac.getBean(obj)

    }
}
