package com.bruno.Deploy.Environments.Variables1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/properties")
public class PropertyController {

    @Autowired
    private Environment environment;

    @GetMapping("/get")
    public String getProperties() {
        return "Hello " + environment.getProperty("myCustomVarTree.devName") + ".Your auth code is: " + environment.getProperty("myCustomVarTree.authCode");
    }
}
