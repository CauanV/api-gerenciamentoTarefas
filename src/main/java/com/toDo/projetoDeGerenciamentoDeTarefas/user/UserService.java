package com.toDo.projetoDeGerenciamentoDeTarefas.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository ){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserModel registerUser(String user, String email, String password){
        String EncriptedPassword = passwordEncoder.encode(password);
        UserModel userModel = new UserModel(user, email, EncriptedPassword);
        return userRepository.save(userModel);
    }

    /*public Optional<UserModel> findByUser(String email) {
        return userRepository.findByEmail(email);
    }*/

    public UserDetails findByUser(String email) {
        return userRepository.findByEmail(email);
    }
}
