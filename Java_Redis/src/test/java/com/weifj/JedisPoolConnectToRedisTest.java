package com.weifj;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisPoolConnectToRedisTest {

    private static JedisPool jedisPool;

    static {
        // 创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(5);
        // 设置等待时间ms(当资源池链接用尽后，调用者最大等待时间)
        jedisPoolConfig.setMaxWaitMillis(100);
        // 其中JedisPool(jedisPoolConfig, host, port, connectionTimeout, password, db)
        jedisPool = new JedisPool(jedisPoolConfig, "124.223.118.214", 6379, 100, "123456", 0);
    }

    /**
     * 获取Jedis
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }



    /**
     *  连接Redis
     * @param args
     */
    public static void main(String[] args) {
        // 创建Jedis对象，连接Redis服务器，其中Jedis(host,port)
        Jedis jedis = getJedis();

        // 使用ping命令，测试是否连接成功
        String ping = jedis.ping();
        System.out.println(ping); // 返回PONG

        // 添加一条数据
        jedis.set("username","zhagnsan");

        // 获取一条命令
        String username = jedis.get("username");
        System.out.println(username);

        // 释放资源
        if (jedis != null){
            jedis.close();
        }

    }

}
