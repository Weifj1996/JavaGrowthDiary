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
        // 写入数据
        redisTemplate.opsForValue().set("username","Hello Reids!");
        // 读取数据
        String username = (String) redisTemplate.opsForValue().get("username");
        // 验证
        assertEquals("Hello Reids!",username);

    }

}
