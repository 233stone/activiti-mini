package com.guoleilei.activiti.engine.task;

import com.guoleilei.activiti.engine.ActivitiIllegalArgumentException;
import com.guoleilei.activiti.engine.query.Query;


/**
 * 这个接口所有的方法都是做筛选的，通过传入特定的条件定位出要查询的结果。
 * 所有的方法返回值都是T，所有这个接口不进行最后结果的汇总，只做筛选
 * @param <T>
 * @param <V>
 */
public interface TaskInfoQuery<T extends TaskInfoQuery<?, ?>, V extends TaskInfo> extends Query<T, V> {

    T taskId(String taskId);

//    T taskName(String name);

    /**
     * 只筛选出名称在给定列表中的任务
     *
     * @throws ActivitiIllegalArgumentException
     *           当传递的名称列表为空或为 null 或包含 null 字符串时抛异常
     */
//    T taskNameIn(List<String> nameList);


    /**
     * 所有被调用的查询子句都将被添加到一个单一的或语句中。这个或语句将与查询中其他已存在的子句通过一个“与”连接在一起。调用 endOr() 会将所有子句再次添加到常规查询中。
     *
     * 在调用 endOr() 之后调用 or() 会导致异常。
     */
    T or();

    T endOr();

    /**
     * 根据taskId排序
     */
    T orderByTaskId();

}
