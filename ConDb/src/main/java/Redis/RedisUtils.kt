package Redis

import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig
import java.io.IOException
import java.util.*


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/20/21
 * @Software: IntelliJ IDEA
 */
class RedisUtils {
    companion object {

        var pool: JedisPool? = null
        var poolConfig = JedisPoolConfig()
        var proKey = HashMap<String, String>()
        var pro = Properties()

    }

    init {
        //加载配置文件
        val conf = JedisPoolUtil::class.java.classLoader.getResourceAsStream("redis.properties")

        try {
            pro.load(conf)
        } catch (e: IOException) {
            e.printStackTrace()
            println("加载配置文件失败")
        }
        for (k in pro.propertyNames()) {
//            println("$k:${pro.get(k)}")
            proKey[k.toString()] = pro[k].toString()
        }



        poolConfig.maxTotal = proKey["maxTotal"].toString().toInt()
        poolConfig.maxIdle = proKey["maxIdle"].toString().toInt()
        poolConfig.minIdle = proKey["minIdle"].toString().toInt()


        // public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password)
        pool = JedisPool(
            poolConfig,
            proKey["url"].toString(),
            proKey["port"].toString().toInt(),
            proKey["timeout"].toString().toInt(),
            proKey["password"].toString()
        )
    }

    fun getJedis(): Jedis? {
        return RedisUtils.pool?.resource
    }

    fun getJedisWithHP(url: String? = null): Jedis? {

        url ?: let {

            println("--无参登录--")
            return Jedis()
        }
        url.let {
            if (url.indexOf(":") < 0) {
                println("输入参数有误")
                return null
            }
            return Jedis(url.split(":")[0], url.split(":")[1].toInt())
        }
    }

    fun closeConn(jedis: Jedis?) {
        jedis?.close()
    }


}