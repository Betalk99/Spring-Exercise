package co.develhope.exer.controller.swagger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/names")
public class NameController {

    private String reverseName(String name){
        return new StringBuilder(name).reverse().toString();
    }

    @GetMapping("/echo/normal")
    @Tag(name = "echo", description = "Get del nome dato tramite parametro")
    @ApiResponse(description = "OK", responseCode = "200")
    @ApiResponse(description = "KO", responseCode = "400")
    @ApiResponse(description = "BOH", responseCode = "500")
    @Operation(summary = "Restituisce il nome dato tramite parametro")
    public String getEchoedName(@Parameter(name = "Nome",required = true, description = "Nome dato tramite parametro") @RequestParam String name) {
        return name;
    }

    @PostMapping("/echo/reverse")
    @Tag(name = "echo")
    @ApiResponse(description = "OK", responseCode = "200")
    @ApiResponse(description = "KO", responseCode = "400")
    @ApiResponse(description = "BOH", responseCode = "500")
    @Operation(summary = "Restituisce il nome dato all'incontrario")
    public String postEchoedName(@RequestBody(required = true) String name) {
        return reverseName(name);
    }



}