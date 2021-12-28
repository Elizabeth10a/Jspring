package Mongodb

import com.mongodb.*
import com.mongodb.client.MongoDatabase
import java.util.*


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/19/21
 * @Software: IntelliJ IDEA
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MongoDBUtils {
    var configuration: String = "mongoDB.properties"
    var options: MongoClientOptions? = null
    var mc: MongoClient? = null
    var pro = Properties()
    var proKey = HashMap<String, String>()
    var credentials: List<MongoCredential>? = ArrayList()
    val sAddress: MutableList<ServerAddress> = ArrayList()

    init {
        val conf = MongoClient::class.java.classLoader.getResourceAsStream(configuration)
        this.pro.load(conf)
        for (k in this.pro.propertyNames()) {
//            println("$k:${this.pro.get(k)}")
            this.proKey[k.toString()] = this.pro[k].toString()
        }

        proKey[Pro.MaxWaitTime.name]?.let {
            this.options =
                proKey[Pro.MaxWaitTime.name]?.let { it1 ->
                    MongoClientOptions.builder().maxWaitTime(it.toInt()).maxConnectionIdleTime(it1.toInt())
                        .sslEnabled(false).build()
                }
        }
        //ServerAddress()两个参数分别为 服务器地址 和 端口

        this.sAddress.add(
            ServerAddress(this.proKey[Pro.Host.name], this.proKey[Pro.Port.name]!!.toInt())
        )
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码

        this.credentials = listOf(
            MongoCredential.createScramSha1Credential(
                this.proKey[Pro.Username.name],
                this.proKey[Pro.Database.name],
                this.proKey[Pro.Pwd.name]?.toCharArray(),
            )
        )
    }

/*
*
*   public MongoClient() {
        this(new ServerAddress());
    }

    public MongoClient(String host) {
        this(ServerAddressHelper.createServerAddress(host));
    }

    public MongoClient(String host, MongoClientOptions options) {
        this(ServerAddressHelper.createServerAddress(host), options);
    }

    public MongoClient(String host, int port) {
        this(ServerAddressHelper.createServerAddress(host, port));
    }

    public MongoClient(ServerAddress addr) {
        this(addr, (new Builder()).build());
    }
* */

    fun loginWithAddress(database: String? = null): MongoDatabase? {
        this.mc = MongoClient(this.sAddress)
        // 连接到数据库
        database?.let { return this.mc?.getDatabase(database) }
        return this.mc?.getDatabase(this.proKey[Pro.Database.name])//MongoClient
    }

    fun loginWithHP(database: String? = null): MongoDatabase? {
        // 连接到 mongodb 服务
        this.mc = this.proKey[Pro.Host.name]?.let {
            MongoClient(this.proKey[Pro.Host.name], this.proKey[Pro.Port.name]!!.toInt())
        }
        // 连接到数据库
        database?.let { return this.mc?.getDatabase(database) }
        return this.mc?.getDatabase(this.proKey[Pro.Database.name])//MongoClient


    }

    fun loginWithHost(database: String? = null): MongoDatabase? {

        //通过连接认证获取MongoDB连接
        this.mc = MongoClient(this.proKey[Pro.Host.name]) //创建 非认证客户端
        //连接到数据库
        println("Connect to database successfully")
        database?.let { return this.mc?.getDatabase(database) }
        return mc!!.getDatabase(this.proKey[Pro.Database.name])
    }

    fun loginWithOptions(database: String? = null): MongoDatabase? {
        this.mc = MongoClient(this.sAddress, this.options)
        database?.let { return this.mc?.getDatabase(database) }
        return mc!!.getDatabase(this.proKey[Pro.Database.name])
    }

    fun loginWithUri(database: String? = null): MongoClient? {
//        mongodb://userName:password@host/?authSource=databaseName&ssh=true;
//        mongodb://192.168.20.129:27017
        database?.let {
            this.mc = MongoClient(
                MongoClientURI(
                    "mongodb://${proKey[Pro.Username.name]}:" +
                            "${proKey[Pro.Pwd.name]}" +
                            "@${proKey[Pro.Host.name]}:" +
                            "${proKey[Pro.Port.name]}" +
                            "/?authSource=${database}" +
                            "&ssl=false"
                )
            )
            return this.mc
        }
        this.mc = MongoClient(
            MongoClientURI(
                "mongodb://${proKey[Pro.Username.name]}:" +
                        "${proKey[Pro.Pwd.name]}" +
                        "@${proKey[Pro.Host.name]}:" +
                        "${proKey[Pro.Port.name]}" +
                        "/?authSource=${proKey[Pro.Database.name]}" +
                        "&ssl=false"
            )
        )
        return this.mc
    }

}

enum class Pro(s: String) {
    Host("192 168 20 129"),
    Port("27017"),
    Username("root"),
    Pwd("root"),
    Database(""),
    MaxWaitThread("50"),
    MaxTimeout("60"),
    MaxWaitTime("60"),
    MaxConnect("50"),
}