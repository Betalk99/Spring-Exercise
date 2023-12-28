package com.bo.ControllerGetAndPostExercise;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class NameController {

    private String reverseName(String name){
        return new StringBuilder(name).reverse().toString();
    }

    @GetMapping("/echo")
    public String getEchoedName(@RequestParam String name) {
        return name;
    }

    @PostMapping("/echo")
    public String postEchoedName(@RequestBody String name) {
        return reverseName(name);
    }



}
