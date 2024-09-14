package com.guoleilei.activiti.engine.task;

import java.util.Date;
import java.util.Map;

/**
 * 这个接口中只有getter方法，适用于只有读取场景的业务，例如对历史记录的查询，肯定是用不到写的。
 * 我理解的这样设计主要是服用代码上，之后历史任务的查询可以使用这里的代码，还有一个就是安全性，也是对于历史任务来说
 * setter方法再子类Task中，也是相当于服用了这里的代码
 */
public interface TaskInfo {

    String getId();

    String getName();

    String getDescription();

    int getPriority();

    String getOwner();

    String getAssignee();

    String getProcessInstanceId();

    String getExecutionId();

    String getProcessDefinitionId();

    Date getCreateTime();

    String getTaskDefinitionKey();

    Date getDueDate();

    String getCategory();

    String getParentTaskId();

    String getTenantId();

    String getFormKey();

    Map<String, Object> getTaskLocalVariables();

    Map<String, Object> getProcessVariables();

    Date getClaimTime();
}
