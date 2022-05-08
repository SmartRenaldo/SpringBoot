package com.awesome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testSet() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 18);
    }

    @Test
    void testGet() {
        ValueOperations ops = redisTemplate.opsForValue();
        System.out.println(ops.get("age"));
    }

    @Test
    void testHset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("msg", "a", "scash");
    }

    @Test
    void testHget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object o = ops.get("msg", "a");
        System.out.println(o);
    }

}
