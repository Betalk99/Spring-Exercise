package com.bruno.APIInterceptor.Middleware2.controllers;


import com.bruno.APIInterceptor.Middleware2.entities.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {


    @GetMapping
    public Month getMonth(@RequestAttribute("month") Month month) {
        return month;
    }



}
