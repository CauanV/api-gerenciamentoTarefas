package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> taskList(){
        return taskRepository.findAll(); //findAll retorna uma lista
    }

    public TaskModel concludedTask(Long id) {
        TaskModel task = taskRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Task nao encontrada " + id));
        task.setConcluded(true);
        return taskRepository.save(task);//esse save(task) só acontece se a tarefa tiver sido encontrada. ele ja sai do metodo concludedTask devido ElseThrow
    }

    public TaskModel taskCreate(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel listById(Long id){
        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task nao encontrada " + id));
        return task;
    }

    public String deleteById(Long id){
        taskRepository.deleteById(id);
        return "Task" + id + "successful deleted";
    }

}
