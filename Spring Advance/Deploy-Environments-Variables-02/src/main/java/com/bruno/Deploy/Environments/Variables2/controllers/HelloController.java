package com.bruno.Deploy.Environments.Variables2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @Autowired
    private Environment environment;

    @GetMapping("/get")
    public String get(){
        return environment.getProperty("myCustomVarTree.welcomeMsg");
    }


}
