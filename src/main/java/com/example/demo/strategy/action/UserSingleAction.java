package com.example.demo.strategy.action;

import com.example.demo.context.DomainContext;
import com.example.demo.context.enums.MngCodeEnum;
import com.example.demo.factory.ManagerFactory;
import com.example.demo.strategy.AbstractManagerAction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserSingleAction extends AbstractManagerAction {

    @Resource
    ManagerFactory managerFactory;

    @Override
    public boolean doCheckParam(DomainContext context) {
        return false;
    }

    @Override
    public boolean doExecute() {
        System.out.println("执行UserSingleAction具体业务----");
        return true;
    }

    @Override
    public String setCode() {
        return MngCodeEnum.USER_SINGLE.getName();
    }

    @Override
    public void afterPropertiesSet() {
        managerFactory.putAction(this.setCode(), this);
    }
}
