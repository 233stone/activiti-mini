package com.guoleilei.activiti.engine.impl.persistence.entity.data;

import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.db.DbSqlSession;
import com.guoleilei.activiti.engine.impl.persistence.AbstractManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.Entity;

public abstract class AbstractDataManager<EntityImpl extends Entity> extends AbstractManager implements DataManager<EntityImpl> {

    public AbstractDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    protected DbSqlSession getDbSqlSession() {
        return getSession(DbSqlSession.class);
    }

    @Override
    public EntityImpl findById(String entityId) {
        if (entityId == null) {
            return null;
        }

        // Cache
//        EntityImpl cachedEntity = getEntityCache().findInCache(getManagedEntityClass(), entityId);
//        if (cachedEntity != null) {
//            return cachedEntity;
//        }

        // Database
        return getDbSqlSession().selectById(getManagedEntityClass(), entityId, false);
    }

    public abstract Class<? extends EntityImpl> getManagedEntityClass();

}
