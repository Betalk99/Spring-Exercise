package com.bruno.Deploy2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/operation")
@RestController
public class OperationController {

    @GetMapping("/sum")
    public Double sum(@RequestParam Double num1, @RequestParam Double num2) {

        return num1 + num2;

    }

}
