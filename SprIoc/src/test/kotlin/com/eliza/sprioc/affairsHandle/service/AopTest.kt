package com.eliza.sprioc.affairsHandle.service

import com.eliza.sprioc.affairsHandle.dao.GoodsDao
import com.eliza.sprioc.affairsHandle.dao.SaleDao
import com.eliza.sprioc.spribatis.service.BuyGoodsService
import com.eliza.sprioc.spribatis.service.impl.BuyGoodsServiceImpl
import com.eliza.sprioc.spribatis.utils.UseSpring
import org.junit.jupiter.api.Test

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/7/22
 * @Software: IntelliJ IDEA
 */
internal class AopTest {
    var bsi: BuyGoodsServiceImpl = BuyGoodsServiceImpl()
    var us: UseSpring = UseSpring()

    @Test
    fun getInfo() {
        us.getInfo()

    }

    @Test
    fun getAllSales() {

        val bsii = us.getObject("buyGoodsService") as BuyGoodsService

        bsii.setGoodsDao(us.getObject("goodsDao") as GoodsDao)
        bsii.setSaleDao(us.getObject("saleDao") as SaleDao)
        println(bsii::class)//class jdk.proxy2.$Proxy22


        for (v in bsii.getAllSales()) {
            println(v.toString())
        }
        println(bsii::class.java.name)
    }

}