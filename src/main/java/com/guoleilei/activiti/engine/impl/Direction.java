package com.guoleilei.activiti.engine.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来封装查询排序的方向，实现了一种类似单例模式的类
 * 这里应该是可以用枚举来实现，
 */
public class Direction {

    private static final Map<String, Direction> directions = new HashMap<String, Direction>();

    public static final Direction ASCENDING = new Direction("asc");
    public static final Direction DESCENDING = new Direction("desc");

    private String name;

    public Direction(String name) {
        this.name = name;
        directions.put(name, this);
    }

    public String getName() {
        return name;
    }

    public static Direction findByName(String directionName) {
        return directions.get(directionName);
    }
}
