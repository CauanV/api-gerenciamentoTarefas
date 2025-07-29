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
    @ManyToOne(optional = false)                       // torna o relacionamento opcional mudei agora -> obrigatorio
    @JoinColumn(name = "user_id", nullable = false)    // coluna nao aceita null
    private UserModel user;
}