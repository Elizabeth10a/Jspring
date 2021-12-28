package Mongodb;


import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/19/21
 * @Software: IntelliJ IDEA
 */
public class ccc {

    private MongoClient mc;
//    连接数据库，你需要指定数据库名称，如果指定的数据库不存在，mongo会自动创建数据库。
    public MongoDatabase ccc(int n, int b) throws IOException {
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("192.168.20.129", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("ruby");
            System.out.println("Connect to database successfully");

            return mongoDatabase;

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return null;
    }
// Mongo 需要验证用户名及密码
    public MongoDatabase ccc(int n) throws IOException {
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("192.168.20.129", 27017);

            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("root", "ruby", "root".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
//            MongoClient mongoClient = new MongoClient(addrs, credentials);
            this.mc = new MongoClient(addrs, credentials);        //创建 非认证客户端


            //连接到数据库
            MongoDatabase mongoDatabase = mc.getDatabase("databaseName");
            System.out.println("Connect to database successfully");

            return mongoDatabase;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public void assss() throws IOException {
        InputStream in = ccc.class.getClassLoader().getResourceAsStream("mongoDB.properties");
        Properties pro = new Properties();
        pro.load(in);
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI("mongodb://assad:123@127.0.0.1:27017/?authSource=testdb&ssl=false"));

    }
    public ccc() throws IOException {
        InputStream in = ccc.class.getClassLoader().getResourceAsStream("mongoDB.properties");
        Properties pro = new Properties();
        pro.load(in);

        List<ServerAddress> sAddr = new ArrayList<>();
        sAddr.add(new ServerAddress(pro.getProperty("hosts"), Integer.parseInt(pro.getProperty("port"))));


        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String database = pro.getProperty("database");
        MongoCredential ssd = MongoCredential.createScramSha1Credential(username, database, password.toCharArray());

        MongoClientOptions build = MongoClientOptions.builder()
                .maxConnectionIdleTime(Integer.parseInt(pro.getProperty("maxWaitThread")))
                .maxWaitTime(Integer.parseInt(pro.getProperty("maxWaitTime"))).build();

        this.mc = new MongoClient(sAddr.get(0), ssd, build); //创建认证客户端

//        new MongoClient(sAddr, build);        //创建 非认证客户端


    }


    MongoDatabase mongoDb(String db) {
        return mc.getDatabase(db);

    }


}