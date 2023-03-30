package com.example.demo.pipeline;

import java.util.List;

public interface Pipeline {


    //集成action
    public List<Class> actionList();

    String getName();

}
