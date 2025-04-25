package com.demo.app.controller.redis;

import com.demo.app.redis.RedisBizService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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

    @GetMapping(value = "/put/{key}/{value}")
    public String redissonTest(@PathVariable("key") String key, @PathVariable("value") String value) {
        return redisBizService.putKey(key, value);
    }

}
