package com.example.demo.strategy;

import com.example.demo.context.DomainContext;

public interface Action<T extends DomainContext>{

    boolean execute(DomainContext context);

    String setCode();

    boolean checkParam(DomainContext context);
}
