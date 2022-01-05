package com.eliza.howToCreatObject.note

import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/5/22
 * @Software: IntelliJ IDEA
 */
@Component
class HomeWork {
    var subject: String? = null
    var price = 0

    constructor() {
        println("HomeWork 无参构造")
    }

    constructor(subject: String, price: Int) {
        println("HomeWork 全参构造")

        this.subject = subject
        this.price = price
    }

    override fun toString(): String {
        return "HomeWork(subject='$subject', price=$price)"
    }

}