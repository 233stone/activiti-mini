package com.guoleilei.activiti.engine.history;

import com.guoleilei.activiti.engine.task.TaskInfo;

import java.util.Date;

/**
 * Represents a historic task instance (waiting, finished or deleted) that is stored permanent for statistics, audit and other business intelligence purposes.
 *
 */
public interface HistoricTaskInstance extends TaskInfo, HistoricData {

    /**
     * The reason why this task was deleted {'completed' | 'deleted' | any other user defined string }.
     */
    String getDeleteReason();

    /** Time when the task started. */
    Date getStartTime();

    /** Time when the task was deleted or completed. */
    Date getEndTime();

    /**
     * Difference between {@link #getEndTime()} and {@link #getStartTime()} in milliseconds.
     */
    Long getDurationInMillis();

    /**
     * Difference between {@link #getEndTime()} and {@link #getClaimTime()} in milliseconds.
     */
    Long getWorkTimeInMillis();

    /** Time when the task was claimed. */
    Date getClaimTime();

}
