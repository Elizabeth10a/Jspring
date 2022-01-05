package com.eliza.howToCreatObject.model


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/2/22
 * @Software: IntelliJ IDEA
 */
class User {
    var name: String? = null
    var age = 0
   var goods: Goods?= Goods()

    constructor() {
        println("==User无参构造==")
    }//无参构造

    constructor(name: String) {
        println("==User name构造==")

        this.name = name
    }

    constructor(name: String, age: Int) {
        println("==User name  age构造==")
        this.name = name
        this.age = age
    }

    constructor(name: String?, age: Int, goods: Goods?) {
        println("==User name  age goods构造==")

        this.name = name
        this.age = age
        this.goods = goods
    }

    fun setEmail(email: String) {
        println("email=$email")

    }

    override fun toString(): String {
        return "User(name=$name, age=$age, goods=$goods)"
    }


}