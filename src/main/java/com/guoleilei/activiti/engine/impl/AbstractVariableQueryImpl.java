package com.guoleilei.activiti.engine.impl;

import com.guoleilei.activiti.engine.ActivitiIllegalArgumentException;
import com.guoleilei.activiti.engine.impl.context.Context;
import com.guoleilei.activiti.engine.impl.interceptor.CommandContext;
import com.guoleilei.activiti.engine.impl.interceptor.CommandExecutor;
import com.guoleilei.activiti.engine.impl.variable.VariableTypes;
import com.guoleilei.activiti.engine.query.AbstractQuery;
import com.guoleilei.activiti.engine.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * 进行变量查询的类，queryVariableValues中放的就是调用对变量筛选后存放 筛选条件 的地方
 * @param <T>
 * @param <U>
 */
public abstract class AbstractVariableQueryImpl<T extends Query<?, ?>, U> extends AbstractQuery<T, U> {

    protected List<QueryVariableValue> queryVariableValues = new ArrayList<QueryVariableValue>();


    public AbstractVariableQueryImpl() {
    }

    public AbstractVariableQueryImpl(CommandContext commandContext) {
        super(commandContext);
    }

    public AbstractVariableQueryImpl(CommandExecutor commandExecutor) {
        super(commandExecutor);
    }

    @Override
    public abstract long executeCount(CommandContext commandContext);

    @Override
    public abstract List<U> executeList(CommandContext commandContext);


    public T variableValueEquals(String name, Object value) {
        return variableValueEquals(name, value, true);
    }

    @SuppressWarnings("unchecked")
    protected T variableValueEquals(String name, Object value, boolean localScope) {
        addVariable(name, value, QueryOperator.EQUALS, localScope);
        return (T) this;
    }

    public T variableValueEquals(Object value) {
        return variableValueEquals(value, true);
    }

    @SuppressWarnings("unchecked")
    protected T variableValueEquals(Object value, boolean localScope) {
        queryVariableValues.add(new QueryVariableValue(null, value, QueryOperator.EQUALS, localScope));
        return (T) this;
    }

    /**
     * 在查询之前 初始化变量
     * 遍历调用{@link AbstractVariableQueryImpl#queryVariableValues}的{@link QueryVariableValue#initialize(VariableTypes)}方法
     */
    protected void ensureVariablesInitialized() {
        if (!queryVariableValues.isEmpty()) {
            VariableTypes variableTypes = Context.getProcessEngineConfiguration().getVariableTypes();
            for (QueryVariableValue queryVariableValue : queryVariableValues) {
                queryVariableValue.initialize(variableTypes);
            }
        }
    }

    protected void addVariable(String name, Object value, QueryOperator operator, boolean localScope) {
        if(name == null) {
            throw new ActivitiIllegalArgumentException("name is null");
        }
        queryVariableValues.add(new QueryVariableValue(name, value, operator, localScope));
    }
}
