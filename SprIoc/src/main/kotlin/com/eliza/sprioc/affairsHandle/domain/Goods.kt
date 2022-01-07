package com.eliza.sprioc.affairsHandle.domain


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
class Goods {
    var id: Int? = null
    var name: String? = null
    var amount: Int? = null
    var price: Float? = null

    constructor()

    constructor(name: String?, amount: Int?, price: Float?) {
        this.name = name
        this.amount = amount
        this.price = price
    }

    constructor(id: Int?, name: String?, amount: Int?, price: Float?) {
        this.id = id
        this.name = name
        this.amount = amount
        this.price = price
    }

    constructor(id: Int?, name: String?, amount: Int?) {
        this.id = id
        this.name = name
        this.amount = amount
    }

    override fun toString(): String {
        return "Goods(id=$id, name=$name, amount=$amount, price=$price)"
    }


}