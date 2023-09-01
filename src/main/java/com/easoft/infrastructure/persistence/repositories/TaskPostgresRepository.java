package com.easoft.infrastructure.persistence.repositories;

import com.easoft.domain.entities.Task;
import com.easoft.domain.repositories.TaskRepository;
import com.easoft.infrastructure.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TaskPostgresRepository implements TaskRepository {

    private final TaskJpaRepository repository;

    @Autowired
    public TaskPostgresRepository(TaskJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Task> fetchByID(String id) {
        Optional<TaskEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            Map<String, Object> plainData = new HashMap<>();
            plainData.put("id", entity.get().getTaskID());
            plainData.put("title", entity.get().getTitle());
            plainData.put("description", entity.get().getDescription());
            plainData.put("dueDate", entity.get().getDueDate());

            return Optional.of(Task.fromPrimitives(plainData));
        }

        return Optional.empty();
    }

    @Override
    public void create(Task task) {
        TaskEntity entity = new TaskEntity(
                task.getId().toString(),
                task.getTitle().toString(),
                task.getDescription().toString(),
                task.getDueDate()
        );

        repository.save(entity);
    }
}
