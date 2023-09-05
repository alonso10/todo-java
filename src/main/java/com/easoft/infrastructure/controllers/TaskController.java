package com.easoft.infrastructure.controllers;

import com.easoft.application.task.CreateTask;
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

    private final CreateTask createTaskService;
    private final FetchTaskByID fetchTaskByID;

    @Autowired
    public TaskController(
            CreateTask createTaskService,
            FetchTaskByID fetchTaskByID
    ) {
        this.createTaskService = createTaskService;
        this.fetchTaskByID = fetchTaskByID;
    }


    @PostMapping("/task")
    public void createTask(@RequestBody TaskInputDTO input) {
        createTaskService.execute(input);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Map<String, Object>> getPersonById(@PathVariable String id) {
        return fetchTaskByID.run(id);
    }
}
