package com.easoft.domain.repositories;

import com.easoft.infrastructure.entities.TaskEntity;

import java.util.Optional;


public interface TaskRepository {
    Optional<TaskEntity> fetchByID(String id);

    void create(TaskEntity task);
}
