package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import com.toDo.projetoDeGerenciamentoDeTarefas.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    List<TaskModel> findAllByUser(UserModel user);
}
