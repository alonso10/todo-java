package com.easoft.application.task;

import com.easoft.domain.entities.Task;
import com.easoft.domain.repositories.TaskRepository;
import com.easoft.domain.valueobjects.Identifier;
import com.easoft.domain.valueobjects.StringValueObject;
import com.easoft.infrastructure.dto.TaskInputDTO;
import com.easoft.infrastructure.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTask {

    private final TaskRepository repository;

    @Autowired
    public CreateTask (TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskInputDTO input) {
        Identifier identifier = new Identifier();
        StringValueObject title = new StringValueObject(input.title);
        StringValueObject description = new StringValueObject(input.description);

        Task task = new Task(identifier, title, description, input.dueDate);
        TaskEntity entity = new TaskEntity(
                task.getId().toString(),
                task.getTitle().toString(),
                task.getDescription().toString(),
                task.getDueDate()
        );
        this.repository.create(entity);
    }
}
