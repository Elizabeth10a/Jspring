package com.eliza.sprioc.affairsHandle.dao

import com.eliza.sprioc.affairsHandle.domain.Goods


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
interface GoodsDao {
    //更新库存
    //goods表示本次用户购买的商品信息， id， 购买数量
    fun updateGoods(goods: Goods): Int

    //查询商品的信息
    fun selectGoods(id: Int): Goods?

    fun getAllGoods(): List<Goods>

}