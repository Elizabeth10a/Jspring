package Redis

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/20/21
 * @Software: IntelliJ IDEA
 */
internal class RedisUtilsTest {
    var ru = RedisUtils()

    /**
     * jedis的测试类
     */
    /**
     * 快速入门
     */
    @Test
    fun test1() {
        //1. 获取连接
        val jedis = Jedis("192.168.20.128", 6379)
        //2. 操作
//        jedis.set("username", "zhangsan");
        println(jedis["name"])

        //3. 关闭连接
        jedis.close()
    }

    /**
     * string 数据结构操作
     */
    @Test
    fun test2() {
        //1. 获取连接
        val jedis = Jedis() //如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        //存储
        jedis["username"] = "zhangsan"
        //获取
        val username = jedis["username"]
        println(username)

        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 20, "hehe") //将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对

        //3. 关闭连接
        jedis.close()
    }

    /**
     * hash 数据结构操作
     */
    @Test
    fun test3() {
        //1. 获取连接
        val jedis = Jedis() //如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // 存储hash
        jedis.hset("user", "name", "lisi")
        jedis.hset("user", "age", "23")
        jedis.hset("user", "gender", "female")

        // 获取hash
        val name = jedis.hget("user", "name")
        println(name)


        // 获取hash的所有map中的数据
        val user = jedis.hgetAll("user")

        // keyset
        val keySet: Set<String> = user.keys
        for (key in keySet) {
            //获取value
            val value = user[key]
            println("$key:$value")
        }

        //3. 关闭连接
        jedis.close()
    }

    /**
     * list 数据结构操作
     */
    @Test
    fun test4() {
        //1. 获取连接
        val jedis = Jedis() //如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // list 存储
        jedis.lpush("mylist", "a", "b", "c") //从左边存
        jedis.rpush("mylist", "a", "b", "c") //从右边存

        // list 范围获取
        val mylist = jedis.lrange("mylist", 0, -1)
        println(mylist)

        // list 弹出
        val element1 = jedis.lpop("mylist") //c
        println(element1)
        val element2 = jedis.rpop("mylist") //c
        println(element2)

        // list 范围获取
        val mylist2 = jedis.lrange("mylist", 0, -1)
        println(mylist2)

        //3. 关闭连接
        jedis.close()
    }

    /**
     * set 数据结构操作
     */
    @Test
    fun test5() {
        //1. 获取连接
        val jedis = Jedis() //如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作


        // set 存储
        jedis.sadd("myset", "java", "php", "c++")

        // set 获取
        val myset = jedis.smembers("myset")
        println(myset)

        //3. 关闭连接
        jedis.close()
    }

    /**
     * sortedset 数据结构操作
     */
    @Test
    fun test6() {
        //1. 获取连接
        val jedis = Jedis() //如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // sortedset 存储
        jedis.zadd("mysortedset", 3.0, "亚瑟")
        jedis.zadd("mysortedset", 30.0, "后裔")
        jedis.zadd("mysortedset", 55.0, "孙悟空")

        // sortedset 获取
        val mysortedset = jedis.zrange("mysortedset", 0, -1)
        println(mysortedset)


        //3. 关闭连接
        jedis.close()
    }

    /**
     * jedis连接池使用
     */
    @Test
    fun test7() {

        //0.创建一个配置对象
        val config = JedisPoolConfig()
        config.maxTotal = 50
        config.maxIdle = 10

        //1.创建Jedis连接池对象
        val jedisPool = JedisPool(config, "localhost", 6379)

        //2.获取连接
        val jedis = jedisPool.resource
        //3. 使用
        jedis["hehe"] = "heihei"


        //4. 关闭 归还到连接池中
        jedis.close()
    }

    /**
     * jedis连接池工具类使用
     */
    @Test
    fun test8() {
        val jedis: Jedis = RedisUtils().getJedisWithoutPwd()
        println(jedis.ping())
        jedis["ok"] = "zhangsan"


        //查询所有key
        val keys = jedis.keys("*")
        //遍历、key
        val iterator: Iterator<*> = keys.iterator()
        while (iterator.hasNext()) {
            val key = iterator.next() as String
            println("$key : ${jedis[key] }")
        }
    }

    @Test
    fun asa() {
    }
}