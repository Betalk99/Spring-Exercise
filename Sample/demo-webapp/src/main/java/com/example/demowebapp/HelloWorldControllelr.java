package com.example.demowebapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloWorldControllelr {
    @RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(path = "/ciao")
    public String ciao(@RequestParam(value = "pippo", required = false, defaultValue = "Bruno") String nome, @RequestParam(required = false) String cognome){
        return "Hello " + nome + " " + cognome;
    }

    @GetMapping(path = "/ciao/{id}")
    public User ciao(
            @PathVariable long id,
            @RequestParam(value = "pippo", required = false, defaultValue = "Bruno") String nome,
            @RequestParam(required = false) String cognome){
        return new User(id, nome, cognome);
    }

}
