package com.seeleaf.usercenter.service;
import com.seeleaf.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("seeleafString", "fuck");
        valueOperations.set("seeleafInt", 12);
        valueOperations.set("seeleafDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("seeleaf");
        valueOperations.set("seeleafUser", user);
        // 查
        Object fuck = valueOperations.get("seeleafString");
        Assertions.assertTrue("fuck".equals((String) fuck));
        Object seeleafInt = valueOperations.get("seeleafInt");
        Assertions.assertTrue(12 == (Integer) seeleafInt);
        Object seeleafDouble = valueOperations.get("seeleafDouble");
        Assertions.assertTrue(2.0 == (Double) seeleafDouble);
        System.out.println(valueOperations.get("seeleafUser"));
    }
}
