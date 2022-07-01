package com.study.config;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {


    @GetMapping("/commonTest")
    public String redisTest(){
        List<String> strings = new ArrayList<>();
        return "";
    }

}
