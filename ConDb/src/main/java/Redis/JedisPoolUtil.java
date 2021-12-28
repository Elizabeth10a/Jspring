package Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class JedisPoolUtil {
    private static JedisPool pool = null;

    static {
        //加载配置文件
        InputStream in = JedisPoolUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载配置文件失败");
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("maxTotal").toString()));
        //最大空闲连接数
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("maxIdle").toString()));
        //最小空闲连接数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("minIdle").toString()));
        int timeout = Integer.parseInt(pro.get("timeout").toString());
        String password = pro.get("password").toString();
        // public JedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password)
        pool = new JedisPool(
                poolConfig,
                pro.get("url").toString(),
                Integer.parseInt(pro.get("port").toString()),
                timeout,
                password);

    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void release(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }
}