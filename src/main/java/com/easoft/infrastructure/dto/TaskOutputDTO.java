package com.easoft.infrastructure.dto;

import java.io.Serializable;
import java.sql.Date;

public class TaskOutputDTO implements Serializable {

    public String id;

    public String title;

    public String description;

    public Date dueDate;
}
