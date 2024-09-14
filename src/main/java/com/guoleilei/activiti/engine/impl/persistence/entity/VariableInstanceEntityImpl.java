package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.variable.VariableType;

import java.io.Serializable;

public class VariableInstanceEntityImpl extends AbstractEntity implements VariableInstanceEntity, Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;
    protected VariableType type;
    protected String typeName;

    protected String processInstanceId;
    protected String executionId;
    protected String taskId;

    protected Long longValue;
    protected Double doubleValue;
    protected String textValue;
    protected String textValue2;
//    protected ByteArrayRef byteArrayRef;

    protected Object cachedValue;
    protected boolean forcedUpdate;
    protected boolean deleted;

    public VariableInstanceEntityImpl() {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public void setTypeName(String typeName) {

    }

    @Override
    public Object getPersistentState() {
        return null;
    }

    @Override
    public void setType(VariableType type) {

    }
}
