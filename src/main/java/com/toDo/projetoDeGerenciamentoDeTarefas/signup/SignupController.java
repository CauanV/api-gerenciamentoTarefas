package com.toDo.projetoDeGerenciamentoDeTarefas.signup;


import com.toDo.projetoDeGerenciamentoDeTarefas.user.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SignupController {


    @PostMapping("/register")
    public String signup(@ModelAttribute UserModel dados){
        /*
        * Você escreveu @ModelAttribute UserModel dados no parâmetro do método.
        O Spring, ao receber o POST /signup, lê o corpo da requisição.
        Ele vê que os campos do formulário são, por exemplo:
        name=João&email=joao@gmail.com&password=123
        O Spring procura uma classe (UserModel) e vê que ela: Está pública.
        Tem um construtor sem argumentos (@NoArgsConstructor).
        Tem setters públicos para os campos name, email, password.
        * **************************
        * O Spring associa os dados do formulário aos atributos do objeto Java com base exclusivamente na comparação dos nomes dos campos
        * */
        // Aqui o 'dados' já tem name, email, password preenchidos
        System.out.println("Nome: " + dados.getUsername());
        System.out.println("Email: " + dados.getEmail());
        System.out.println("Senha: " + dados.getPassword());
        // Aqui você pode salvar no banco (se tiver um repository)
        // repository.save(dados);
        return "Cadastro feito com sucesso...";
    }
}
