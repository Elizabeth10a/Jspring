package com.eliza.sprioc.affairsHandle.dao

import com.eliza.sprioc.affairsHandle.domain.Goods
import com.eliza.sprioc.affairsHandle.domain.Sale


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
interface SaleDao {
    //增加销售记录
    fun insertSale(sale: Sale): Int
    fun getAllSales():List<Sale>
}