package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import com.toDo.projetoDeGerenciamentoDeTarefas.user.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean concluded;

    //associar com o usuario
    @ManyToOne(optional = true)                       // torna o relacionamento opcional
    @JoinColumn(name = "user_id", nullable = true)    // coluna aceita null
    private UserModel user;

}