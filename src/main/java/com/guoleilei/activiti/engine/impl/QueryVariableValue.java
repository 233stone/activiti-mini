package com.guoleilei.activiti.engine.impl;

import com.guoleilei.activiti.engine.ActivitiIllegalArgumentException;
import com.guoleilei.activiti.engine.impl.context.Context;
import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import com.guoleilei.activiti.engine.impl.variable.ByteArrayType;
import com.guoleilei.activiti.engine.impl.variable.JPAEntityListVariableType;
import com.guoleilei.activiti.engine.impl.variable.JPAEntityVariableType;
import com.guoleilei.activiti.engine.impl.variable.VariableType;
import com.guoleilei.activiti.engine.impl.variable.VariableTypes;

import java.io.Serializable;

/**
 * 表示在查询中使用的变量值，主要是对查询变量的封装
 */
public class QueryVariableValue implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Object value;
    private QueryOperator operator;

    private VariableInstanceEntity variableInstanceEntity;
    private boolean local;

    public QueryVariableValue(String name, Object value, QueryOperator operator, boolean local) {
        this.name = name;
        this.value = value;
        this.operator = operator;
        this.local = local;
    }

    public void initialize(VariableTypes types) {
        if (variableInstanceEntity == null) {
            VariableType type = types.findVariableType(value);
            if (type instanceof ByteArrayType) {
                throw new ActivitiIllegalArgumentException("Variables of type ByteArray cannot be used to query");
            } else if (type instanceof JPAEntityVariableType && operator != QueryOperator.EQUALS) {
                throw new ActivitiIllegalArgumentException("JPA entity variables can only be used in 'variableValueEquals'");
            } else if (type instanceof JPAEntityListVariableType) {
                throw new ActivitiIllegalArgumentException("Variables containing a list of JPA entities cannot be used to query");
            } else {
                // Type implementation determines which fields are set on the entity
                variableInstanceEntity = Context.getCommandContext().getVariableInstanceEntityManager().create(name, type, value);
            }
        }
    }
}
