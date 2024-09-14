package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.variable.VariableType;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface VariableInstanceEntityManager extends EntityManager<VariableInstanceEntity> {

    VariableInstanceEntity create(String name, VariableType type, Object value);

    List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId);

//    List<VariableInstanceEntity> findVariableInstancesByTaskIds(Set<String> taskIds);
//
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
//
//    void deleteVariableInstanceByTask(TaskEntity task);

}
