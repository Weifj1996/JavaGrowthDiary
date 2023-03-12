package com.weifj;

import redis.clients.jedis.Jedis;

public class ConnectToRedisTest {

    /**
     *  连接Redis
     * @param args
     */
    public static void main(String[] args) {
        // 创建Jedis对象，连接Redis服务器，其中Jedis(host,port)
        Jedis jedis = new Jedis("124.223.118.214", 6379);

        // 设置认证密码，如果没有可以设置为空
        jedis.auth("123456");

        // 指定的数据库 默认为0
        jedis.select(1);

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
