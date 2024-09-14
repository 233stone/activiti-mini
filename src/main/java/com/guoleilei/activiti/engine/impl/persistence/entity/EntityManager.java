package com.guoleilei.activiti.engine.impl.persistence.entity;

public interface EntityManager<EntityImpl extends Entity> {

    EntityImpl create();

    EntityImpl findById(String entityId);


}
