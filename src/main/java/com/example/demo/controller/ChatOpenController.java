package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.utils.ChatHttpClientUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/open")
public class ChatOpenController {

    @Resource
    ChatHttpClientUtil chatHttpClientUtil;

    @PostMapping("/chatApi")
    public Result<Object> httpChat(@RequestParam(required = false) String message) throws IOException {
        chatHttpClientUtil.relay(message);
        return Result.success();
    }

    @PostMapping("/relay")
    public Result<Object> relay(@RequestParam(required = false) String message){
        System.setProperty("http.proxyHost","127.0.0.1");
        System.setProperty("http.proxyPort","8081");
        return Result.success(chatHttpClientUtil.requestChatOpenPost(message));
    }
}
