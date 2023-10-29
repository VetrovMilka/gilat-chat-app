package org.students.ninjas.firstTask.entity.factory;

import org.students.ninjas.firstTask.entity.BaseEntity;

/**
 * The type Base entity factory.
 */
public class BaseEntityFactory {
    /**
     * Gets base entity.
     *
     * @param abstractFactory the abstract factory
     * @return the base entity
     */
    public static BaseEntity getBaseEntity(AbstractBaseEntityFactory abstractFactory) {
        return abstractFactory.createEntity();
    }
}
