package DynamicProxy.Aspect.Service

import DynamicProxy.Aspect.model.User


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
interface SomeService {

    fun doSome(name: String, age: Int)
    fun doOther(name: String, age: Int): String
    fun doUser(name: String, age: Int): User
    fun doAround(name: String, age: Int): User
    fun doAfterThrowing(x: Int, y: Int)

}