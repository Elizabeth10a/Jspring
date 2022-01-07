package com.eliza.sprioc.affairsHandle.excep


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
class NotEnoughException : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)

}