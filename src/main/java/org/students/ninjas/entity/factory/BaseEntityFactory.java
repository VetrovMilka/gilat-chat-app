package org.students.ninjas.entity.factory;

import org.students.ninjas.entity.BaseEntity;

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
