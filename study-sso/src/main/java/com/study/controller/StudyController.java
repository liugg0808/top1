package com.study.controller;


import com.study.config.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
public class StudyController {

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/redisTest")
    public String redisTest(){
        redisCache.setCacheObject("aaa","bbb");
        return "";
    }

}
