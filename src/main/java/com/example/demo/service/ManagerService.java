package com.example.demo.service;

import com.example.demo.context.DomainContext;
import com.example.demo.factory.ManagerFactory;
import com.example.demo.strategy.Action;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ManagerService {

    @Resource
    ManagerFactory managerFactory;

    public void execute(DomainContext context){
        context.setCode("user_all");
        Action action = managerFactory.getAction(context.getCode());
        action.execute(context);
    }
}
