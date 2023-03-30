package com.example.demo.pipeline.impl;

import com.example.demo.action.impl.UserCheckAction;
import com.example.demo.action.impl.UserExecuteAction;
import com.example.demo.pipeline.Pipeline;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserPipeline implements Pipeline {
    @Override
    public List<Class> actionList() {
        return Arrays.asList(UserCheckAction.class, UserExecuteAction.class);
    }

    @Override
    public String getName() {
        return "用户执行链";
    }
}
