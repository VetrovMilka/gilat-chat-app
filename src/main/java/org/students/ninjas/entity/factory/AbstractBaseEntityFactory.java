package org.students.ninjas.entity.factory;

import org.students.ninjas.entity.BaseEntity;

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
