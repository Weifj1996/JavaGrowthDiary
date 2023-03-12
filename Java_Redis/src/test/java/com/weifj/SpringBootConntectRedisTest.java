package com.weifj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class SpringBootConntectRedisTest {


    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void testConnection(){
        String ping = redisTemplate.getConnectionFactory().getConnection().ping();
        assertEquals("PONG",ping);
    }

    @Test
    void testOptString(){
        // д������
        redisTemplate.opsForValue().set("username","Hello Reids!");
        // ��ȡ����
        String username = (String) redisTemplate.opsForValue().get("username");
        // ��֤
        assertEquals("Hello Reids!",username);

    }

}
