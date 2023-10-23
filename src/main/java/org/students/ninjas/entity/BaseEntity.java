package org.students.ninjas.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity {
    protected int id;
    protected LocalDateTime createdAt;

    public BaseEntity(int id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }
}
