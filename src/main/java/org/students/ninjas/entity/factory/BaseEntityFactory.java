package org.students.ninjas.entity.factory;

import org.students.ninjas.entity.BaseEntity;

public class BaseEntityFactory {
    public static BaseEntity getBaseEntity(AbstractBaseEntityFactory abstractFactory) {
        return abstractFactory.createEntity();
    }
}
