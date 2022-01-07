package com.eliza.sprioc.spribatis.service.impl

import com.eliza.sprioc.affairsHandle.dao.GoodsDao
import com.eliza.sprioc.affairsHandle.dao.SaleDao
import com.eliza.sprioc.affairsHandle.domain.Goods
import com.eliza.sprioc.affairsHandle.domain.Sale
import com.eliza.sprioc.affairsHandle.excep.NotEnoughException
import com.eliza.sprioc.spribatis.service.BuyGoodsService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional


@Component("buyGoodsService")
class BuyGoodsServiceImpl : BuyGoodsService {
    lateinit var ud: GoodsDao
    lateinit var sd: SaleDao

    override   fun setGoodsDao(ud: GoodsDao) {
        this.ud = ud
    }

    override   fun setSaleDao(sd: SaleDao) {
        this.sd = sd
    }

    override fun updateGoods(goods: Goods): Int {
        return ud.updateGoods(goods)

    }

    override fun getAllGoods(): List<Goods> {
        return ud.getAllGoods()
    }

    //spring  注解
    /**
     *
     * rollbackFor:表示发生指定的异常一定回滚.
     *   处理逻辑是：
     *     1) spring框架会首先检查方法抛出的异常是不是在rollbackFor的属性值中
     *         如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚。
     *     2) 如果你的抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException,
     *         如果是一定回滚。
     *
     */
/*    @Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        readOnly = false,
        rollbackFor = [NotEnoughException::class, NullPointerException::class],
    )*/

    //使用的是事务控制的默认值， 默认的传播行为是REQUIRED，默认的隔离级别DEFAULT
    //默认抛出运行时异常，回滚事务。

    @Transactional
    //需要将其变为事务，即sale  good s同时被操作 要购买的商品id ，购买数量
    override fun buy(goodsId: Int, nums: Int) {

        println("=====buy方法的开始====")

        //记录销售信息，向sale表添加记录
        sd.insertSale(Sale(goodsId, nums))

        //更新库存
        val goods = ud.selectGoods(goodsId)
        goods ?: throw NullPointerException("编号是：$goodsId,商品不存在")
        if (goods.amount!! < nums) throw NotEnoughException("编号是：$goodsId,商品库存不足")

        //如果有商品且数量足够
        //修改库存了 (数据库语句自动减)
        ud.updateGoods(Goods(goods.id, goods.name, nums))
        println("=====buy方法的完成====")
    }

    override fun getAllSales(): List<Sale> {
        return sd.getAllSales()
    }


}