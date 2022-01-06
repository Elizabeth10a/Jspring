package DynamicProxy.Aspect.Service

import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("noInterface")
class NoInterface {
    fun doSomeThing() {
        println("没有实现接口 NoInterface doSomeThing")
    }
}