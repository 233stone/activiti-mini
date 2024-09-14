package com.guoleilei.activiti.engine.history;

import com.guoleilei.activiti.engine.task.TaskInfoQuery;

import java.util.Date;

/**
 * Allows programmatic querying for {@link HistoricTaskInstance}s.
 *
 */
public interface HistoricTaskInstanceQuery extends TaskInfoQuery<HistoricTaskInstanceQuery, HistoricTaskInstance> {

    /** Only select historic task instances with the given task delete reason. */
    HistoricTaskInstanceQuery taskDeleteReason(String taskDeleteReason);

    /**
     * Only select historic task instances with a task description like the given value. The syntax that should be used is the same as in SQL, eg. %activiti%.
     */
    HistoricTaskInstanceQuery taskDeleteReasonLike(String taskDeleteReasonLike);

    /**
     * Only select historic task instances which are finished.
     */
    HistoricTaskInstanceQuery finished();

    /**
     * Only select historic task instances which aren't finished yet.
     */
    HistoricTaskInstanceQuery unfinished();

    /**
     * Only select historic task instances which are part of a process instance which is already finished.
     */
    HistoricTaskInstanceQuery processFinished();

    /**
     * Only select historic task instances which are part of a process instance which is not finished yet.
     */
    HistoricTaskInstanceQuery processUnfinished();

    /**
     * Only select select historic task instances which are completed on the given date
     */
    HistoricTaskInstanceQuery taskCompletedOn(Date endDate);

    /**
     * Only select select historic task instances which are completed before the given date
     */
    HistoricTaskInstanceQuery taskCompletedBefore(Date endDate);

    /**
     * Only select select historic task instances which are completed after the given date
     */
    HistoricTaskInstanceQuery taskCompletedAfter(Date endDate);

    // ORDERING

    /**
     * Order by the historic activity instance id this task was used in (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    HistoricTaskInstanceQuery orderByHistoricActivityInstanceId();

    /**
     * Order by duration (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    HistoricTaskInstanceQuery orderByHistoricTaskInstanceDuration();

    /**
     * Order by end time (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    HistoricTaskInstanceQuery orderByHistoricTaskInstanceEndTime();

    /**
     * Order by start time (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    HistoricTaskInstanceQuery orderByHistoricTaskInstanceStartTime();

    /**
     * Order by task delete reason (needs to be followed by {@link #asc()} or {@link #desc()}).
     */
    HistoricTaskInstanceQuery orderByDeleteReason();

}
