package com.bruno.Deploy1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/deploy")
public class DeployController {

    @Autowired
    private Environment environment;
    @GetMapping
    public String deploy(){
        return environment.getRequiredProperty("myCustomVarTree.customVar");
    }


}
