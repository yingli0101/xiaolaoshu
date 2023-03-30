package com.example.demo.action.impl;

import com.example.demo.action.CheckAction;
import com.example.demo.context.DomainContext;
import org.springframework.stereotype.Component;

@Component
public class UserCheckAction implements CheckAction {
    @Override
    public void execute(DomainContext context) {
        //这里执行具体的action
        System.out.println("执行到UserCheckAction");
    }
}
