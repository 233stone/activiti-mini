package com.guoleilei.activiti.engine.impl.persistence.entity;

import com.guoleilei.activiti.engine.impl.TaskQueryImpl;
import com.guoleilei.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

public interface TaskEntityManager extends EntityManager<TaskEntity> {

//    void insert(TaskEntity taskEntity, ExecutionEntity execution);
//
//    void changeTaskAssignee(TaskEntity taskEntity, String assignee);
//
//    void changeTaskAssigneeNoEvents(TaskEntity taskEntity, String assignee);
//
//    void changeTaskOwner(TaskEntity taskEntity, String owner);
//
//    List<TaskEntity> findTasksByExecutionId(String executionId);
//
//    List<TaskEntity> findTasksByProcessInstanceId(String processInstanceId);

    List<Task> findTasksByQueryCriteria(TaskQueryImpl taskQuery);

    List<Task> findTasksAndVariablesByQueryCriteria(TaskQueryImpl taskQuery);

    long findTaskCountByQueryCriteria(TaskQueryImpl taskQuery);

//    List<Task> findTasksByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults);
//
//    long findTaskCountByNativeQuery(Map<String, Object> parameterMap);
//
//    List<Task> findTasksByParentTaskId(String parentTaskId);
//
//    void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId);
//
//    void deleteTask(String taskId, String deleteReason, boolean cascade);
//
//    void deleteTask(String taskId, String deleteReason, boolean cascade, boolean cancel);
//
//    void deleteTasksByProcessInstanceId(String processInstanceId, String deleteReason, boolean cascade);
//
//    void deleteTask(TaskEntity task, String deleteReason, boolean cascade, boolean cancel);

}
