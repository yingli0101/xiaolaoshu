package com.example.demo.controller;

import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @PostMapping
    public Result<Object> health(){
        return Result.success("success");
    }
}
