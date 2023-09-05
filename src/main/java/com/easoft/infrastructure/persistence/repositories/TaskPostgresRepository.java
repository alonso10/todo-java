package com.easoft.infrastructure.persistence.repositories;

import com.easoft.domain.repositories.TaskRepository;
import com.easoft.infrastructure.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TaskPostgresRepository implements TaskRepository {

    private final TaskJpaRepository repository;

    @Autowired
    public TaskPostgresRepository(TaskJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<TaskEntity> fetchByID(String id) {
        return repository.findById(id);
    }

    @Override
    public void create(TaskEntity task) {
        repository.save(task);
    }
}
