package com.example.brunoOrl.ExeControllerconQueryParameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloController {
    @GetMapping(path = "/ciao")
    public String ciao(@RequestParam(value = "nome") String nome, @RequestParam(value = "provincia") String provincia){
        return "Ciao " + nome + ", com'è il tempo in " + provincia + "?";
    }
}
