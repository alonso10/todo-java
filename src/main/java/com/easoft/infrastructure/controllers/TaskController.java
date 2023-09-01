package com.easoft.infrastructure.controllers;

import com.easoft.application.task.FetchTaskByID;
import com.easoft.domain.entities.Task;
import com.easoft.domain.repositories.TaskRepository;
import com.easoft.domain.valueobjects.Identifier;
import com.easoft.domain.valueobjects.StringValueObject;
import com.easoft.infrastructure.dto.TaskInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private FetchTaskByID fetchTaskByID;


    @PostMapping("/task")
    public void createTask(@RequestBody TaskInputDTO input) {
        System.out.println(input);
        Identifier identifier = new Identifier();
        StringValueObject  title = new StringValueObject(input.title);
        StringValueObject description = new StringValueObject(input.description);

        Task task = new Task(identifier, title, description, input.dueDate);
        repository.create(task);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Map<String, Object>> getPersonById(@PathVariable String id) {
        return fetchTaskByID.run(id);
    }
}
