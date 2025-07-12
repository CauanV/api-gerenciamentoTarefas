package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel){// ResponseEntity<TaskModel> permite configurar a resposta HTTP,
                                                                    // incluindo o status (ex: 201 Created) e o corpo (a Task criada em formato JSON)
        TaskModel task = taskService.taskCreate(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/products")
    public List<TaskModel> getTasks(){
        return taskService.taskList();
    }

    @GetMapping("/{id}")//entre chaves o parametro vai ser um pathvariable
    public TaskModel productById(@PathVariable Long id){
        return taskService.listById(id);
    }
}
