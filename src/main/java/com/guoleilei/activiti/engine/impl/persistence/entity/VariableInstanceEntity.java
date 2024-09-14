package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.variable.VariableType;

public interface VariableInstanceEntity extends VariableInstance {

//    void setDeleted(boolean isDeleted);
//
//    boolean isDeleted();

//    void setExecution(ExecutionEntity execution);

//    void forceUpdate();

//    ByteArrayRef getByteArrayRef();

//    VariableType getType();

    void setType(VariableType type);

}