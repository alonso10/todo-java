package com.easoft.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "tasks", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity {
    @Id
    @Column(name = "task_id")
    private String taskID;

    private String title;

    private String description;

    @Column(name = "due_date")
    private Date dueDate;
}
