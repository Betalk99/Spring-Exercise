package com.bruno.Servizi.Logging.controllers;

import com.bruno.Servizi.Logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    private BasicService basicService;
    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String welcome() {
        logger.info("Welcome to the application!");
        return "Welcome to the application!";
    }

    @GetMapping("/exp")
    public double exp() {
        int num1 = Integer.parseInt(environment.getProperty("myCustomVarTree.ENV1"));
        int num2 = Integer.parseInt(environment.getProperty("myCustomVarTree.ENV2"));
        return basicService.calculatePower(num1, num2);
    }

    @GetMapping("/get-errors")
    public void getErrors() throws Exception {
        logger.warn("New Exception");
        throw new Exception("New Exception");
    }
}
