package com.eliza.sprioc.affairsHandle.domain


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
class Sale {
    var id: Int? = null
    var gid: Int? = null
    var nums: Int? = null

    constructor()
    constructor(id: Int?, gid: Int?, nums: Int?) {
        this.id = id
        this.gid = gid
        this.nums = nums
    }

    constructor(gid: Int?, nums: Int?) {
        this.gid = gid
        this.nums = nums
    }

    override fun toString(): String {
        return "Sale(id=$id, gid=$gid, nums=$nums)"
    }


}