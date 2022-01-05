package Mongodb

import com.mongodb.client.FindIterable
import com.mongodb.client.MongoCollection
import org.bson.Document
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/19/21
 * @Software: IntelliJ IDEA
 */
internal class MongoDBUtilsTest {
    var mdb: MongoDBUtils = MongoDBUtils()

    @Test
    fun getPro() {

        for (k in mdb.pro.propertyNames()) {
            println("$k:${mdb.pro.get(k)}")
        }

        for (k in mdb.proKey.keys) {
            println("$k : ${mdb.proKey[k]}")

        }

    }


    @Test
    fun with() {
    }

    @Test
    fun loginWithAddress() {
        val hp = mdb.loginWithAddress()
        println(hp?.name)
    }

    @Test
    fun loginWithHP() {
        val hp = mdb.loginWithHP()
        println(hp?.name)

    }

    @Test
    fun loginWithHost() {
        val hp = mdb.loginWithHost()
        println(hp?.name)
    }

    @Test
    fun loginWithOptions() {
//        val hp = mdb.loginWithOptions("ruby")
        val hp = mdb.loginWithHost()

        println(hp?.name)
        val doc: MongoCollection<Document> = hp!!.getCollection("info")

        val iter: FindIterable<Document> = doc.find()
        iter.forEach { it -> println(it) }

    }

    @Test
    fun loginWithUri() {
        val mc = mdb.loginWithUri()
        val db = mc?.getDatabase("ruby")
        val doc: MongoCollection<Document> = db!!.getCollection("info")

        val iter: FindIterable<Document> = doc.find()
        iter.forEach { it -> println(it) }
    }
}