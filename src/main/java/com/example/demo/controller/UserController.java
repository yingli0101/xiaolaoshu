package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.context.DomainContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/test")
    public void test(){
        DomainContext domainContext = buildContext();
        userService.test(domainContext);
    }

    private DomainContext buildContext() {
        return new DomainContext();
    }
}
