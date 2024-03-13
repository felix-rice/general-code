package com.felix.general.code.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felix.general.code.core.service.RedisService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-13
 */
@RestController("general-code-api/")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("setName")
    public Boolean setName() {
        redisService.set("name", "zhangsan");
        return true;
    }
}
