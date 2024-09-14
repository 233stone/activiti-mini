package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.persistence.entity.data.DataManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.data.VariableInstanceDataManager;
import com.guoleilei.activiti.engine.impl.variable.VariableType;

import java.util.List;

public class VariableInstanceEntityManagerImpl extends AbstractEntityManager<VariableInstanceEntity> implements VariableInstanceEntityManager {

    protected VariableInstanceDataManager variableInstanceDataManager;

    public VariableInstanceEntityManagerImpl(ProcessEngineConfigurationImpl processEngineConfiguration, VariableInstanceDataManager variableInstanceDataManager) {
        super(processEngineConfiguration);
        this.variableInstanceDataManager = variableInstanceDataManager;
    }


    @Override
    public VariableInstanceEntity create(String name, VariableType type, Object value) {
        VariableInstanceEntity variableInstance = create();
        variableInstance.setName(name);
        variableInstance.setType(type);
        variableInstance.setTypeName(type.getTypeName());
        variableInstance.setValue(value);
        return variableInstance;
    }

    @Override
    protected DataManager<VariableInstanceEntity> getDataManager() {
        return variableInstanceDataManager;
    }

    @Override
    public List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId) {
        return variableInstanceDataManager.findVariableInstancesByTaskId(taskId);
    }
}
