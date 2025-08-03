package com.toDo.projetoDeGerenciamentoDeTarefas.task;

import com.toDo.projetoDeGerenciamentoDeTarefas.user.UserModel;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    //@AuthenticationPrincipal= Ela injeta automaticamente o usuário que está logado (autenticado via Spring Security) dentro do seu método

    @PostMapping("/create")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel, @AuthenticationPrincipal UserModel user){// ResponseEntity<TaskModel> permite configurar a resposta HTTP,
                                                                    // incluindo o status (ex: 201 Created) e o corpo (a Task criada em formato JSON)
        taskModel.setUser(user);  // Associa o usuário autenticado à tarefa
        //precisa associar explicitamente a tarefa ao usuário logado dentro do metodo, antes de salvar
        TaskModel task = taskService.taskCreate(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/list")
    public List<TaskModel> getTasks(@AuthenticationPrincipal UserModel user){
        return taskService.taskListByUser(user);
    }

    @GetMapping("/{id}")//entre chaves o parametro vai ser um pathvariable
    public TaskModel productById(@PathVariable Long id){
        return taskService.listById(id);
    }

    @PutMapping("/update/{id}/{concluded}")
    public TaskModel updateById(@PathVariable Long id, @PathVariable boolean concluded){
            return taskService.updateById(id,concluded);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return taskService.deleteById(id);
    }
}
