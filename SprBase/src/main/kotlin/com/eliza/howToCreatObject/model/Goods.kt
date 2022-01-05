package com.eliza.howToCreatObject.model

import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/5/22
 * @Software: IntelliJ IDEA
 */

class Goods {
    var name: String? = null
    var price = 0

    constructor() {
        println("goods 无参构造")
    }

    constructor(name: String?, price: Int) {
        println("==Goods name  price ==")
        this.name = name
        this.price = price
    }


    override fun toString(): String {
        return "Goods(name=$name, price=$price)"
    }

}