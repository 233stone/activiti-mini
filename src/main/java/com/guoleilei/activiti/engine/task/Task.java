package com.guoleilei.activiti.engine.task;


import java.util.Date;

/**
 * Represents one task for a human user.
 *
 */
public interface Task extends TaskInfo {

    /**
     * Default value used for priority when a new {@link Task} is created.
     */
    int DEFAULT_PRIORITY = 50;

    void setName(String name);

    void setLocalizedName(String name);

    void setDescription(String description);

    void setLocalizedDescription(String description);

    void setPriority(int priority);

//    /**
//     * The {@link User.getId() userId} of the person that is responsible for this task.
//     */
//    void setOwner(String owner);
//
//    /**
//     * The {@link User.getId() userId} of the person to which this task is delegated.
//     */
//    void setAssignee(String assignee);
//
//    /** The current {@link DelegationState} for this task. */
//    DelegationState getDelegationState();
//
//    /** The current {@link DelegationState} for this task. */
//    void setDelegationState(DelegationState delegationState);

    void setDueDate(Date dueDate);

    void setCategory(String category);

    void setParentTaskId(String parentTaskId);

    void setTenantId(String tenantId);

    void setFormKey(String formKey);

    boolean isSuspended();

}
