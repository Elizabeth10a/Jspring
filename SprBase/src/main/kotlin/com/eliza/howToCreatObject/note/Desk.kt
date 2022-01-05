package com.eliza.howToCreatObject.note

import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/5/22
 * @Software: IntelliJ IDEA
 */
@Component
class Desk {
    var title: String? = null
    var height = 0
    var weight = 0

    constructor() {
        println("Desk 无参构造")
    }

    constructor(title: String?, height: Int, weight: Int) {
        println("Desk 全参构造")
        this.title = title
        this.height = height
        this.weight = weight
    }

    override fun toString(): String {
        return "Desk(title=$title, height=$height, weight=$weight)"
    }

}