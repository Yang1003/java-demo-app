package com.demo.app.controller.redis;

import com.demo.app.redis.RedisBizService;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Hello World
 * @author ZNZZ-2
 */

@RestController
@RequestMapping("/redis")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class RedisController {

    @Resource
    private RedisBizService redisBizService;

    @GetMapping(value = "/redisson/{key}")
    public String redissonTest(@PathVariable("key") String lockKey) {
        return redisBizService.redissonTest(lockKey);
    }

    @GetMapping(value = "/redissonTest2")
    public void redissonTest2() {
        redisBizService.redissonTest2();
    }

}
