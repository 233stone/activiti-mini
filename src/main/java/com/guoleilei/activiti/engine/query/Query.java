package com.guoleilei.activiti.engine.query;

import com.guoleilei.activiti.engine.ActivitiException;

import java.util.List;

/**
 * 最基础的查询方法，这里的方法可以分成两类，一个是继续链式调用，一个是返回最终的结果
 * @param <T> 限定必须是继承自Query的子类，实现了流式API设计（fluent interface），让查询操作可以连续链式调用
 * @param <U> 代表查询结果的实体类型，如ProcessInstance、Task等
 */
public interface Query<T extends Query<?, ?>, U> {

    /**
     * 升序，必须在调用orderBy方法后调用
     */
    T asc();

    /**
     * 降序，必须在调用orderBy方法后调用
     */
    T desc();

    /**
     * 按照{@link QueryProperty}进行排序，最后的排序方向由 {@link #asc()} 或 {@link #desc()} 决定
     */
    T orderBy(QueryProperty property);

    /**
     * 执行查询 并 返回所有的结果数
     */
    long count();

    /**
     *
     * @throws ActivitiException
     * 当查询到的结果不止一个的时候抛出异常
     */
    U singleResult();

    /**
     * 执行查询 并 返回一个实体列表
     */
    List<U> list();

//    /**
//     * 分页查询
//     */
//    List<U> listPage(int firstResult, int maxResults);
}

