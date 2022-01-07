package com.eliza.sprioc.affairsHandle

import com.eliza.sprioc.affairsHandle.dao.GoodsDao
import com.eliza.sprioc.affairsHandle.dao.SaleDao
import com.eliza.sprioc.affairsHandle.domain.Goods
import com.eliza.sprioc.affairsHandle.domain.Sale
import com.eliza.sprioc.spribatis.utils.UseSpring
import org.junit.jupiter.api.Test

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
internal class Affairs {
    var us: UseSpring = UseSpring()


    @Test
    fun getInfo() {
        us.getInfo()

    }

    @Test
    fun selectGoods() {
        var goodsDao = us.getObject("goodsDao") as GoodsDao
        println(goodsDao.selectGoods(1))
    }

    @Test
    fun updateGoods() {
        var goodsDao = us.getObject("goodsDao") as GoodsDao
        println(goodsDao.updateGoods(Goods("as", 12, 34.4f)))
    }
    @Test
    fun insertSale() {
        var saleDao = us.getObject("saleDao") as SaleDao
        println(saleDao.insertSale(Sale(1, 3, 10)))
    }
    @Test
    fun getO() {
        var saleDao = us.getObject("saleDao") as SaleDao
        println(saleDao.insertSale(Sale(1, 3, 10)))
    }

}
