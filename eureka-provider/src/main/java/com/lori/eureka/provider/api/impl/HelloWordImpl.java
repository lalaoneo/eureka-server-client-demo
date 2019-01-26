package com.lori.eureka.provider.api.impl;

import com.lori.eureka.provider.api.HelloWord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordImpl implements HelloWord {

    @Value("${server.port}")
    private String port;

    @Override
    public String hello() {
        return "hello word,my port is : "+ port;
    }
}
