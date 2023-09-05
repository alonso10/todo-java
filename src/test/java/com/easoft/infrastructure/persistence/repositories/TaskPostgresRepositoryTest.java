package com.easoft.infrastructure.persistence.repositories;

import com.easoft.domain.entities.Task;
import com.easoft.domain.valueobjects.Identifier;
import com.easoft.domain.valueobjects.StringValueObject;
import com.easoft.infrastructure.entities.TaskEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TaskPostgresRepositoryTest {

    @Mock
    private TaskJpaRepository jpaRepository;
    @InjectMocks
    private TaskPostgresRepository repository;
    private Task task;
    private TaskEntity entity;

    @BeforeEach
    void setup() {
        Identifier identifier = new Identifier();
        StringValueObject title = new StringValueObject("Test");
        StringValueObject description = new StringValueObject("Test description");
        Date dueDate = new Date(System.currentTimeMillis());

        task = new Task(
                identifier,
                title,
                description,
                dueDate
        );

        entity = TaskEntity.builder()
                .taskID(task.getId().toString())
                .title(task.getTitle().value())
                .description(task.getDescription().value())
                .dueDate(task.getDueDate())
                .build();
    }

    @Test
    void testCreateTask() {
        repository.create(entity);

        verify(jpaRepository, times(1)).save(entity);
    }

    @Test
    void testFetchTaskByID() {

        given(repository.fetchByID(task.getId().toString())).willReturn(Optional.of(entity));

        Optional<TaskEntity> entityFound = repository.fetchByID(task.getId().toString());

        assertThat(entityFound).isNotEmpty();
    }
}
