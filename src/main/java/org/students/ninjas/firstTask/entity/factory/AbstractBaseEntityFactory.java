package org.students.ninjas.firstTask.entity.factory;

import org.students.ninjas.firstTask.entity.BaseEntity;

/**
 * The interface Abstract base entity factory.
 */
public interface AbstractBaseEntityFactory {
    /**
     * Create entity base entity.
     *
     * @return the base entity
     */
    BaseEntity createEntity();
}
