package com.toDo.projetoDeGerenciamentoDeTarefas.login;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    //PostMapping -> vai mandar informacoes
    @PostMapping("/fazerLogin")
    public void signup(@ModelAttribute LoginModel dados){
    }

}
