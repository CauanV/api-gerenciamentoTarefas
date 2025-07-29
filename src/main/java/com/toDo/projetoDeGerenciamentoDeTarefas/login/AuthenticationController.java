package com.toDo.projetoDeGerenciamentoDeTarefas.login;


import com.toDo.projetoDeGerenciamentoDeTarefas.security.TokenService;
import com.toDo.projetoDeGerenciamentoDeTarefas.user.UserModel;
import com.toDo.projetoDeGerenciamentoDeTarefas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);//O authenticationManager vai chamar internamente:
                                             //Um UserDetailsService (dentro de AuthorizationService)→ que busca o usuário no banco de dados pelo e-mail
                                            //Um PasswordEncoder → que compara a senha enviada com a senha criptografada salva no banco
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated AuthenticationDTO data){
        if(this.userRepository.findByEmail(data.email()) != null )//caso exista alguem ja com esse email retorno um badRequest
            return ResponseEntity.badRequest().build();
        else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            //UserModel newUser = new UserModel(data.username(),data.email(), data.password()); aqui a senha ta indo crua pro banco de dados
            UserModel newUser = new UserModel(data.username(),data.email(), encryptedPassword); //aqui ela vai encriptografada
            this.userRepository.save(newUser);
            return ResponseEntity.ok().build();
        }
    }
}
