package com.guoleilei.activiti.engine.task;

import java.util.List;

/**
 * 这个接口也是进行筛选的，被用到的地方是{&#064;TaskService#createTaskQuery() }
 * 为什么要分成这两个接口呢，我理解的还是为了复用TaskInfoQuery，因为还有一个就是和HistoricTaskInstanceQuery接口隔离
 */
public interface TaskQuery extends TaskInfoQuery<TaskQuery, Task> {


    /**
     * 筛选出 已被用户认领 或分配给用户，或正等待用户（候选用户或组）认领的任务。
     */
    public TaskQuery taskCandidateOrAssigned(String userIdForCandidateAndAssignee);

//    /** 筛选没有父任务的任务（即不选择子任务） */
//    TaskQuery excludeSubtasks();

    /**
     * 筛选处于 激活 状态的任务
     */
    TaskQuery active();


}
