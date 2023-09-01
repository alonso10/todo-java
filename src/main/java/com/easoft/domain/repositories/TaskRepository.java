package com.easoft.domain.repositories;

import com.easoft.domain.entities.Task;

import java.util.Optional;


public interface TaskRepository {
    Optional<Task> fetchByID(String id);

    void create(Task task);
}
