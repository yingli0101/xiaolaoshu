package com.example.demo.pipeline;

import com.example.demo.context.DomainContext;

public interface PipelineExecute {

    void executePipeline(Class pipeline, DomainContext context);
}
