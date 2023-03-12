package com.weifj;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class JedisPoolConnectToRedisTest {

    private static JedisPool jedisPool;

    static {
        // �������ӳ����ö���
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // �������������
        jedisPoolConfig.setMaxTotal(5);
        // ���õȴ�ʱ��ms(����Դ�������þ��󣬵��������ȴ�ʱ��)
        jedisPoolConfig.setMaxWaitMillis(100);
        // ����JedisPool(jedisPoolConfig, host, port, connectionTimeout, password, db)
        jedisPool = new JedisPool(jedisPoolConfig, "124.223.118.214", 6379, 100, "123456", 0);
    }

    /**
     * ��ȡJedis
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }



    /**
     *  ����Redis
     * @param args
     */
    public static void main(String[] args) {
        // ����Jedis��������Redis������������Jedis(host,port)
        Jedis jedis = getJedis();

        // ʹ��ping��������Ƿ����ӳɹ�
        String ping = jedis.ping();
        System.out.println(ping); // ����PONG

        // ���һ������
        jedis.set("username","zhagnsan");

        // ��ȡһ������
        String username = jedis.get("username");
        System.out.println(username);

        // �ͷ���Դ
        if (jedis != null){
            jedis.close();
        }

    }

}
