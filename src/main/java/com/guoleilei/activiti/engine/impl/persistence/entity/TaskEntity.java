package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.task.Task;

import java.util.Date;
import java.util.Map;

public interface TaskEntity extends Task, Entity {

//    ExecutionEntity getExecution();

    void setExecutionId(String executionId);

//    void setExecution(ExecutionEntity execution);

//    List<IdentityLinkEntity> getIdentityLinks();

    void setExecutionVariables(Map<String, Object> parameters);

    void setCreateTime(Date createTime);

    void setProcessDefinitionId(String processDefinitionId);

    void setEventName(String eventName);

//    void setCurrentActivitiListener(ActivitiListener currentActivitiListener);

//    ExecutionEntity getProcessInstance();

    void setProcessInstanceId(String processInstanceId);

    int getSuspensionState();

    void setSuspensionState(int suspensionState);

    void setTaskDefinitionKey(String taskDefinitionKey);

//    Map<String, VariableInstanceEntity> getVariableInstanceEntities();

    void forceUpdate();

    boolean isDeleted();

    void setDeleted(boolean isDeleted);

    Date getClaimTime();

    void setClaimTime(Date claimTime);

    boolean isCanceled();

    void setCanceled(boolean isCanceled);
}
