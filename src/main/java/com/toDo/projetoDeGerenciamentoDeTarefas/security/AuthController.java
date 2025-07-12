package com.toDo.projetoDeGerenciamentoDeTarefas.security;

import org.springframework.http.ResponseEntity;
import com.toDo.projetoDeGerenciamentoDeTarefas.user.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody Map<String, String> request){
        UserModel user = userService.registerUser(request.get("userName"), "email" ,"password");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody Map<String, String> request){
        Optional<UserModel> user = userService.findByUser(request.get("userName"));
        if(user.isPresent() && user.get().getPassword().equals(request.get("password"))){
            String token = JwtUtil.generateToken(user.get().getUserName());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("credenciais invalidas");
    }

}
