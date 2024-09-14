package com.guoleilei.activiti.engine.impl.persistence.entity.data;

import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface VariableInstanceDataManager extends DataManager<VariableInstanceEntity> {

    List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId);

//    List<VariableInstanceEntity> findVariableInstancesByTaskIds(Set<String> taskIds);

//    List<VariableInstanceEntity> findVariableInstancesByExecutionId(String executionId);
//
//    List<VariableInstanceEntity> findVariableInstancesByExecutionIds(Set<String> executionIds);
//
//    VariableInstanceEntity findVariableInstanceByExecutionAndName(String executionId, String variableName);
//
//    List<VariableInstanceEntity> findVariableInstancesByExecutionAndNames(String executionId, Collection<String> names);
//
//    VariableInstanceEntity findVariableInstanceByTaskAndName(String taskId, String variableName);
//
//    List<VariableInstanceEntity> findVariableInstancesByTaskAndNames(String taskId, Collection<String> names);

}