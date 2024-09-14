package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.persistence.AbstractManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.data.DataManager;

public abstract class AbstractEntityManager<EntityImpl extends Entity> extends AbstractManager implements EntityManager<EntityImpl> {


    public AbstractEntityManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    @Override
    public EntityImpl create() {
        return getDataManager().create();
    }

    @Override
    public EntityImpl findById(String entityId) {
        return getDataManager().findById(entityId);
    }

    protected abstract DataManager<EntityImpl> getDataManager();
}