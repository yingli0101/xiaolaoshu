package com.example.demo.pipeline;

import org.springframework.beans.factory.InitializingBean;

public interface PipelineRegister extends InitializingBean {
    void register();
    void check();

    @Override
    default void afterPropertiesSet() throws Exception{
        register();
        check();
    }
}
