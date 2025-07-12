package com.toDo.projetoDeGerenciamentoDeTarefas.user;

import com.toDo.projetoDeGerenciamentoDeTarefas.task.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

//Entity transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_users")
public class UserModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    private String userName;
    @Getter @Setter
    @Column(unique = true, nullable = false)
    private String email;
    @Getter @Setter
    @Column(nullable = false)
    private String password;

    public UserModel(){
    }

    public UserModel(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TaskModel> tasks;

}
