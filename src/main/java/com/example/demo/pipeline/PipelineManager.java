package com.example.demo.pipeline;

import com.example.demo.action.IAction;
import com.example.demo.context.DomainContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class PipelineManager implements PipelineRegister,PipelineExecute {

    @Resource
    private List<Pipeline> pipelineList;

    private Map<String, Class> actionMap = new HashMap<>();

    private Map<String, Pipeline> pipelineNameMap = new HashMap<>();
    private Map<String, Pipeline> pipelineClassMap = new HashMap<>();


    @Override
    public void register() {
        //这里实现action和pipeline的绑定
        for (Pipeline pipeline : pipelineList) {
            List<Class> classes = pipeline.actionList();
            for (Class aClass : classes) {
                actionMap.put(aClass.getName(),aClass);
            }
            pipelineNameMap.put(pipeline.getName(),pipeline);
            pipelineClassMap.put(pipeline.getClass().getName(),pipeline);
        }
    }

    @Override
    public void check() {
        //校验action的顺序是否按照规则进行
        for (Pipeline pipeline : pipelineList) {
            List<Class> classes = pipeline.actionList();
            for (int i = 0; i < classes.size(); i++) {
                //比较算法 左右比较 是否符合校验规则 pre->check->execute
            }
        }

    }

    @Override
    public void executePipeline(Class pipeline, DomainContext context) {
        //前置
        doExecute(pipeline,context);
        //后置
    }

    private void doExecute(Class pipeline, DomainContext context) {
        Pipeline pipeline1 = pipelineClassMap.get(pipeline.getName());
        for (Class aClass : pipeline1.actionList()) {
            try {
                IAction action = (IAction)Class.forName(aClass.getName()).newInstance();
                action.execute(context);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
