package com.guoleilei.activiti.engine.impl;

import com.guoleilei.activiti.engine.query.QueryProperty;
import com.guoleilei.activiti.engine.task.TaskQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * 主要使用在 {@link TaskQuery} 类中的排序，是Task包含的所有属性，这里我省略了一部分

 * 我觉得这里完全可以使用静态的String或者枚举来实现，而且更简单，易理解

 * ChatGPT解释的这样设计一个是为了 封装 一个是为了 拓展性 还有 向后兼容 和 类型安全
 *
 */
public class TaskQueryProperty implements QueryProperty {

    private static final long serialVersionUID = 1L;

    private static final Map<String, TaskQueryProperty> properties = new HashMap<>();

    public static final TaskQueryProperty TASK_ID = new TaskQueryProperty("RES.ID_");

    private final String name;

    public TaskQueryProperty(String name) {
        this.name = name;
        properties.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static TaskQueryProperty findByName(String propertyName) {
        return properties.get(propertyName);
    }

}