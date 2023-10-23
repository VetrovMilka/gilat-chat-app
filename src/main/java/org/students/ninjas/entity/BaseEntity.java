package org.students.ninjas.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type Base entity.
 */
@Getter
@Setter
public abstract class BaseEntity {
    /**
     * The id.
     */
    protected int id;
    /**
     * The Created at time.
     */
    protected LocalDateTime createdAt;

    public BaseEntity() {
        this.createdAt = LocalDateTime.now();
    }
}
