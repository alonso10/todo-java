package com.easoft.infrastructure.persistence.repositories;

import com.easoft.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<TaskEntity, String> {
}
