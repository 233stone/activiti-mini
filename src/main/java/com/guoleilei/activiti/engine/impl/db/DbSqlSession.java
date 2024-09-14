package com.guoleilei.activiti.engine.impl.db;

import com.guoleilei.activiti.engine.impl.interceptor.Session;
import com.guoleilei.activiti.engine.impl.persistence.entity.Entity;

import java.util.List;

public class DbSqlSession implements Session {

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }

    @SuppressWarnings("unchecked")
    public <T extends Entity> T selectById(Class<T> entityClass,
                                           String id,
                                           boolean useCache) {
//        T entity = null;
//
//        if (useCache) {
//            entity = entityCache.findInCache(entityClass,
//                    id);
//            if (entity != null) {
//                return entity;
//            }
//        }
//
//        String selectStatement = dbSqlSessionFactory.getSelectStatement(entityClass);
//        selectStatement = dbSqlSessionFactory.mapStatement(selectStatement);
//        entity = (T) sqlSession.selectOne(selectStatement,
//                id);
//        if (entity == null) {
//            return null;
//        }
//
//        entityCache.put(entity,
//                true); // true -> store state so we can see later if it is updated later on
        return null;
    }

    @SuppressWarnings("rawtypes")
    public List selectList(String statement,
                           Object parameter) {
        return null;
    }
}
