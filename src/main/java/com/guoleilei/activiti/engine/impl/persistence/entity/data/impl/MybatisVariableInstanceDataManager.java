package com.guoleilei.activiti.engine.impl.persistence.entity.data.impl;

import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntityImpl;
import com.guoleilei.activiti.engine.impl.persistence.entity.data.AbstractDataManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.data.VariableInstanceDataManager;

import java.util.List;

public class MybatisVariableInstanceDataManager extends AbstractDataManager<VariableInstanceEntity> implements VariableInstanceDataManager {

//    protected CachedEntityMatcher<VariableInstanceEntity> variableInstanceEntity = new VariableByExecutionIdMatcher();

    public MybatisVariableInstanceDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    @Override
    public VariableInstanceEntity create() {
        VariableInstanceEntityImpl variableInstanceEntity = new VariableInstanceEntityImpl();
        variableInstanceEntity.setRevision(0); // For backwards compatibility, variables / HistoricVariableUpdate assumes revision 0 for the first time
        return variableInstanceEntity;
    }


    @Override
    public Class<? extends VariableInstanceEntity> getManagedEntityClass() {
        return VariableInstanceEntityImpl.class;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId) {
        return getDbSqlSession().selectList("selectVariablesByTaskId", taskId);
    }

}
