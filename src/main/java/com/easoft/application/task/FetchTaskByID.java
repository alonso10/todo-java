package com.easoft.application.task;

import com.easoft.domain.entities.Task;
import com.easoft.domain.repositories.TaskRepository;
import com.easoft.infrastructure.dto.TaskOutputDTO;
import com.easoft.infrastructure.entities.TaskEntity;
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
        Optional<Task> task = this.process(id);

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

    private Optional<Task> process(String id) {
        Optional<TaskEntity> entity = repository.fetchByID(id);
        Optional<Task> task = Optional.empty();

        if (entity.isPresent()) {
            Map<String, Object> plainData = new HashMap<>();
            plainData.put("id", entity.get().getTaskID());
            plainData.put("title", entity.get().getTitle());
            plainData.put("description", entity.get().getDescription());
            plainData.put("dueDate", entity.get().getDueDate());

            task = Optional.of(Task.fromPrimitives(plainData));
        }
        return task;
    }
}

