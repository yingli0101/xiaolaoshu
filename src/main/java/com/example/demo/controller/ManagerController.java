package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.context.DomainContext;
import com.example.demo.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    ManagerService managerService;

    @GetMapping("/all")
    public Result<Boolean> manager(DomainContext context) {
        managerService.execute(context);
        return Result.success(true);
    }
}
