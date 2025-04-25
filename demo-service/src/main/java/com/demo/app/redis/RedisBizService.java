package com.demo.app.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * .
 *
 * @author wangjiayang
 * @Email wangjiayang@fiberhome.com
 * @date 2025/4/24 19:22
 */
@Service
@Slf4j
public class RedisBizService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public String putKey(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "success";
    }

}
