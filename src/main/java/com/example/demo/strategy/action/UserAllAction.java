package com.example.demo.strategy.action;

import com.example.demo.context.DomainContext;
import com.example.demo.context.enums.MngCodeEnum;
import com.example.demo.factory.ManagerFactory;
import com.example.demo.strategy.AbstractManagerAction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserAllAction extends AbstractManagerAction {

    @Resource
    ManagerFactory managerFactory;


    @Override
    public boolean doCheckParam(DomainContext context) {
        //规则不通过 不会执行下一步
        return true;
    }

    @Override
    public boolean doExecute() {
        System.out.println("执行UserAllAction具体业务---");
        return true;
    }

    @Override
    public String setCode() {
        return MngCodeEnum.USER_ALL.getName();
    }

    @Override
    public void afterPropertiesSet() {
        managerFactory.putAction(this.setCode(),this);
    }
}
