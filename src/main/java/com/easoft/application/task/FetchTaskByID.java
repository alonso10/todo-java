package com.easoft.application.task;

import com.easoft.domain.entities.Task;
import com.easoft.domain.repositories.TaskRepository;
import com.easoft.infrastructure.dto.TaskOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FetchTaskByID {

    @Autowired
    private TaskRepository repository;

    public ResponseEntity<Map<String, Object>> run(String id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Task> task = repository.fetchByID(id);

        if (task.isPresent()) {
            TaskOutputDTO output = new TaskOutputDTO();
            output.id = task.get().getId().toString();
            output.title = task.get().getTitle().value();
            output.description = task.get().getDescription().value();
            output.dueDate = task.get().getDueDate();

            response.put("data", output);
            return ResponseEntity.ok(response);
        }

        response.put("message", "Task not found");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(404));
    }
}

