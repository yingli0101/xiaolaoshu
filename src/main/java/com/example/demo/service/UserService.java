package com.example.demo.service;

import com.example.demo.context.DomainContext;
import com.example.demo.pipeline.PipelineExecute;
import com.example.demo.pipeline.impl.UserPipeline;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

    @Resource
    PipelineExecute pipelineExecute;

    public void test(DomainContext context) {
        pipelineExecute.executePipeline(UserPipeline.class, context);
    }
}
