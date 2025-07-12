package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

}
