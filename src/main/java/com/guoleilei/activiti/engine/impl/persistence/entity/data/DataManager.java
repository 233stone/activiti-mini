package com.guoleilei.activiti.engine.impl.persistence.entity.data;

import com.guoleilei.activiti.engine.impl.persistence.entity.Entity;

/**

 */
public interface DataManager<EntityImpl extends Entity> {

    EntityImpl create();

    EntityImpl findById(String entityId);

}