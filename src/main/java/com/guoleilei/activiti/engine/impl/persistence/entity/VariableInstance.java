package com.guoleilei.activiti.engine.impl.persistence.entity;

/**

 *
 * Generic variable class that can be reused for Activiti 6 and 5 engine
 */
public interface VariableInstance extends Entity {

    void setName(String name);
//
//    void setProcessInstanceId(String processInstanceId);
//
//    void setExecutionId(String executionId);
//
//    Object getValue();
//
    void setValue(Object value);
//
//    String getTypeName();

    void setTypeName(String typeName);

//    String getProcessInstanceId();
//
//    String getTaskId();
//
//    void setTaskId(String taskId);
//
//    String getExecutionId();

}
