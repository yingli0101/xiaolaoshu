package com.example.demo.controller;

import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @PostMapping
    public Result<Object> home(@RequestBody(required = false) Object body) {
        System.out.println("接收到前端请求参数:" + body.toString());
        return Result.success("success");
    }
}
