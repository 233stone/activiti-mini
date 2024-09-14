package com.guoleilei.activiti.engine.impl.cfg;

import com.guoleilei.activiti.engine.impl.persistence.entity.TaskEntityManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntityManager;

import com.guoleilei.activiti.engine.impl.variable.VariableTypes;

public class ProcessEngineConfigurationImpl {

    protected VariableTypes variableTypes;


    protected TaskEntityManager taskEntityManager;
    private VariableInstanceEntityManager variableInstanceEntityManager;

//    protected PerformanceSettings performanceSettings = new PerformanceSettings();


    public TaskEntityManager getTaskEntityManager() {
        return taskEntityManager;
    }


    public VariableTypes getVariableTypes() {
        return variableTypes;
    }



    public VariableInstanceEntityManager getVariableInstanceEntityManager() {
        return variableInstanceEntityManager;
    }

//    public PerformanceSettings getPerformanceSettings() {
//        return performanceSettings;
//    }

}
