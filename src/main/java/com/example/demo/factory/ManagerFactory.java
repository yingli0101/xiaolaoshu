package com.example.demo.factory;

import com.example.demo.strategy.Action;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ManagerFactory {

    private final Map<String, Action> hashMap = new HashMap<>();


    public Action getAction(String pathCode) {
        return hashMap.get(pathCode);
    }

    public void putAction(String pathCode, Action action) {
        hashMap.put(pathCode, action);
    }


}
