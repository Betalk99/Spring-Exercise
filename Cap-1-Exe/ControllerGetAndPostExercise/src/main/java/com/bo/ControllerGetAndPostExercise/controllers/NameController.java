package com.bo.ControllerGetAndPostExercise.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/names")
public class NameController {

    private String reverseName(String name){
        return new StringBuilder(name).reverse().toString();
    }

    @GetMapping("/echo/normal")
    public String getEchoedName(@RequestParam String name) {
        return name;
    }

    @PostMapping("/echo/reverse")
    public String postEchoedName(@RequestBody String name) {
        return reverseName(name);
    }



}
