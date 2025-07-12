package com.toDo.projetoDeGerenciamentoDeTarefas.login;

import com.toDo.projetoDeGerenciamentoDeTarefas.task.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<TaskModel, Long> {

}
