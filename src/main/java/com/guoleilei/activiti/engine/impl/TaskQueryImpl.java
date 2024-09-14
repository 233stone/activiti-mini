package com.guoleilei.activiti.engine.impl;

import com.guoleilei.activiti.engine.ActivitiException;
import com.guoleilei.activiti.engine.ActivitiIllegalArgumentException;
import com.guoleilei.activiti.engine.impl.context.Context;
import com.guoleilei.activiti.engine.impl.interceptor.CommandContext;
import com.guoleilei.activiti.engine.impl.interceptor.CommandExecutor;
import com.guoleilei.activiti.engine.impl.persistence.entity.SuspensionState;
import com.guoleilei.activiti.engine.impl.variable.VariableTypes;
import com.guoleilei.activiti.engine.task.Task;
import com.guoleilei.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class TaskQueryImpl extends AbstractVariableQueryImpl<TaskQuery, Task> implements TaskQuery {
    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(TaskQueryImpl.class);

    protected String taskId;
    protected String name;
    protected String candidateUser;
    protected String candidateGroup;
    protected SuspensionState suspensionState;
    protected boolean includeTaskLocalVariables;
    protected boolean includeProcessVariables;
    protected String userIdForCandidateAndAssignee;
    protected boolean bothCandidateAndAssigned;
    protected boolean orActive;
    protected List<TaskQueryImpl> orQueryObjects = new ArrayList<TaskQueryImpl>();
    protected TaskQueryImpl currentOrQueryObject = null;



    public TaskQueryImpl() {
    }

    public TaskQueryImpl(CommandContext commandContext) {
        super(commandContext);
    }

    public TaskQueryImpl(CommandExecutor commandExecutor) {
        super(commandExecutor);
    }


    //////////////////////////////////////////////
    // 实现{@link TaskInfoQuery} 的方法

    @Override
    public TaskQuery taskId(String taskId) {
        if (taskId == null) {
            throw new ActivitiIllegalArgumentException("Task id is null");
        }

        if (orActive) {
            currentOrQueryObject.taskId = taskId;
        } else {
            this.taskId = taskId;
        }
        return this;
    }

    @Override
    public TaskQuery or() {
        if (orActive) {
            throw new ActivitiException("the query is already in an or statement");
        }

        // Create instance of the orQuery
        orActive = true;
        currentOrQueryObject = new TaskQueryImpl();
        orQueryObjects.add(currentOrQueryObject);
        return this;
    }

    @Override
    public TaskQuery endOr() {
        if (!orActive) {
            throw new ActivitiException("endOr() can only be called after calling or()");
        }

        orActive = false;
        currentOrQueryObject = null;
        return this;
    }

    @Override
    public TaskQuery orderByTaskId() {
        return orderBy(TaskQueryProperty.TASK_ID);
    }



    //////////////////////////////////////////////
    // 实现 {@link AbstractQuery} 的方法
    @Override
    public List<Task> executeList(CommandContext commandContext) {
        ensureVariablesInitialized();
        checkQueryOk();
        List<Task> tasks = null;
        if (includeTaskLocalVariables || includeProcessVariables) {
            tasks = commandContext.getTaskEntityManager().findTasksAndVariablesByQueryCriteria(this);
        } else {
            tasks = commandContext.getTaskEntityManager().findTasksByQueryCriteria(this);
        }

//        if (tasks != null && Context.getProcessEngineConfiguration().getPerformanceSettings().isEnableLocalization()) {
//            for (Task task : tasks) {
//                localize(task);
//            }
//        }

        return tasks;
    }

    @Override
    public long executeCount(CommandContext commandContext) {
        ensureVariablesInitialized();
        checkQueryOk();
        return commandContext.getTaskEntityManager().findTaskCountByQueryCriteria(this);
    }



    protected void ensureVariablesInitialized() {
        VariableTypes types = Context.getProcessEngineConfiguration().getVariableTypes();

        for (QueryVariableValue var : queryVariableValues) {
            var.initialize(types);
        }

        for (TaskQueryImpl orQueryObject : orQueryObjects) {
            orQueryObject.ensureVariablesInitialized();
        }
    }


    //////////////////////////////////////////////
    // 实现{@link TaskQuery} 的方法

    @Override
    public TaskQuery taskCandidateOrAssigned(String userIdForCandidateAndAssignee) {
        if (candidateGroup != null) {
            throw new ActivitiIllegalArgumentException("Invalid query usage: cannot set candidateGroup");
        }
        if (candidateUser != null) {
            throw new ActivitiIllegalArgumentException("Invalid query usage: cannot set both candidateGroup and candidateUser");
        }

        if(orActive) {
            currentOrQueryObject.bothCandidateAndAssigned = true;
            currentOrQueryObject.userIdForCandidateAndAssignee = userIdForCandidateAndAssignee;
        } else {
            this.bothCandidateAndAssigned = true;
            this.userIdForCandidateAndAssignee = userIdForCandidateAndAssignee;
        }

        return this;
    }


    @Override
    public TaskQuery active() {
        if(orActive) {
            currentOrQueryObject.suspensionState = SuspensionState.ACTIVE;
        } else {
            this.suspensionState = SuspensionState.ACTIVE;
        }
        return this;
    }
}
