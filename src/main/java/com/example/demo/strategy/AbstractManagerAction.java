package com.example.demo.strategy;


import com.example.demo.context.DomainContext;
import com.example.demo.context.enums.MngCodeEnum;

public abstract class AbstractManagerAction implements Action<DomainContext>, ActionRegister {



    //定义算法模板
    @Override
    public boolean execute(DomainContext context) {
        //或者统一转换为相同的请求入参
        boolean flag = false;
        //前置校验
        if (checkParam(context)) {
            flag = MngCodeEnum.getMngCodeByCode(context.getCode()).isTran() ? tranExecute() : doExecute();
        }
        //后置校验
        return flag;
    }

    @Override
    public boolean checkParam(DomainContext context) {
        //具体校验规则由子类校验
        return doCheckParam(context);
    }

    public boolean tranExecute(){
        //事务状态执行 transactionTemplate.execute(content -> {content.doExecute()});
        return doExecute();
    }

    public abstract boolean doCheckParam(DomainContext context);

    public abstract boolean doExecute();


}
