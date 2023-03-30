package com.example.demo.action;

import com.example.demo.context.DomainContext;

public interface IAction<T extends DomainContext>{
    //具体执行方法
    public void execute(DomainContext  context);
}
