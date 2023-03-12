package com.weifj;

import redis.clients.jedis.Jedis;

public class ConnectToRedisTest {

    /**
     *  ����Redis
     * @param args
     */
    public static void main(String[] args) {
        // ����Jedis��������Redis������������Jedis(host,port)
        Jedis jedis = new Jedis("124.223.118.214", 6379);

        // ������֤���룬���û�п�������Ϊ��
        jedis.auth("123456");

        // ָ�������ݿ� Ĭ��Ϊ0
        jedis.select(1);

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
