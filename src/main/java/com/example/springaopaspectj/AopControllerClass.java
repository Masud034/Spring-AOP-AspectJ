package com.example.springaopaspectj;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class AopControllerClass {

    @GetMapping(value = "/aopcontroller/hello")
    public String greetings() {
        return "Hello From Aop Controller";
    }
}
