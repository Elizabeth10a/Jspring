package com.eliza.sprioc.spribatis.service

import com.eliza.sprioc.affairsHandle.dao.GoodsDao
import com.eliza.sprioc.affairsHandle.dao.SaleDao
import com.eliza.sprioc.affairsHandle.domain.Goods
import com.eliza.sprioc.affairsHandle.domain.Sale


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */

//业务层，处理信息，并调用数据库方法
interface BuyGoodsService {
    fun updateGoods(goods: Goods): Int
    fun getAllGoods():  List<Goods>
    fun buy(goodsId: Int, nums: Int)
    fun getAllSales(): List<Sale>

    fun setSaleDao(sd: SaleDao)
    fun setGoodsDao(ud: GoodsDao)
}
