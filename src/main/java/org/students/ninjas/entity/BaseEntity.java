package org.students.ninjas.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    protected int id;
    protected LocalDateTime createdAt;

    public BaseEntity(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
