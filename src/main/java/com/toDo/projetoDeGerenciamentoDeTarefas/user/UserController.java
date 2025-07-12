package com.toDo.projetoDeGerenciamentoDeTarefas.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {


    /*GetMapping -> puxar informacoes
    *PostMapping -> vai mandar informacoes
    *PutMapping -> vai alterar informacoes
    *PatchMapping -> tambem altera informacoes
    * DeleteMapping -> deleta informacoes
    */
    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Primeiro teste de mensagem, nessa rota!";
    }

    @Autowired
    private UserRepository userRepository;

}