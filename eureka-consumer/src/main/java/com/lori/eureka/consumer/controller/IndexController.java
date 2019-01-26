package com.lori.eureka.consumer.controller;

import com.lori.eureka.consumer.feign.client.HelloWordClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private HelloWordClient client;

    @RequestMapping("index")
    public String index(){
        return "index "+client.hello();
    }
}
