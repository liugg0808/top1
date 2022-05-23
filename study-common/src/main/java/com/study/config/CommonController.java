package com.study.config;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {


    @GetMapping("/commonTest")
    public String redisTest(){
        return "";
    }

}
