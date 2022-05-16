package com.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

}
