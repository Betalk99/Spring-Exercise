package com.example.brunoOrl.ControllerconGETcompleta;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @NonNull
    private String nome;
     @NonNull
    private String provincia;
     @NonNull
    private String saluto;


    public User(String nome, String provincia) {
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = "Ciao " + nome + ", com'è il tempo in " + provincia +"?";;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(@NonNull String provincia) {
        this.provincia = provincia;
    }

    @NonNull
    public String getSaluto() {
        return saluto;
    }

    public void setSaluto(@NonNull String saluto) {
        this.saluto = saluto;
    }
}


