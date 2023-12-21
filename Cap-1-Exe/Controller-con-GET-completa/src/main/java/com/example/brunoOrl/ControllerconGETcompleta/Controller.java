package com.example.brunoOrl.ControllerconGETcompleta;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class Controller {

    @GetMapping(path = "/ciao/{pro}")
    public User ciao(
            @PathVariable String pro,
            @RequestParam(value = "nome") String nome){
        return new User(nome, pro);
    }


}
