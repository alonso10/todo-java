package com.easoft.domain.entities;

import com.easoft.domain.valueobjects.Identifier;
import com.easoft.domain.valueobjects.StringValueObject;

import java.sql.Date;
import java.util.Map;

public class Task {

    private final Identifier id;
    private final StringValueObject title;
    private final StringValueObject description;
    private final Date dueDate;

    public Task(Identifier id, StringValueObject title, StringValueObject description, Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static Task fromPrimitives(Map<String, Object> plainData) {
        Identifier id = new Identifier((String) plainData.get("id"));
        StringValueObject title = new StringValueObject((String) plainData.get("title"));
        StringValueObject description = new StringValueObject((String) plainData.get("description"));
        Date dueDate = (Date) plainData.get("dueDate");

        return new Task(id, title, description, dueDate);
    }

    public Identifier getId() {
        return id;
    }

    public StringValueObject getTitle() {
        return title;
    }

    public StringValueObject getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
