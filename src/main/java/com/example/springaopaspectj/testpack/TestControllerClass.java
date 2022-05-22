package com.example.springaopaspectj.testpack;

import com.example.springaopaspectj.model.RequestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerClass {

    @GetMapping(value = "/testpack/hello")
    public String hellofromTestPack() {
        return "Hello From Test Package";
    }

    @PostMapping(value = "/testpack/requestBody")
    public RequestModel withRequestModelFromTestPack(@RequestBody RequestModel requestModel) {
        return requestModel;
    }
}
