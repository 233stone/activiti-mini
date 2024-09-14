package com.guoleilei.activiti.engine.impl.db;

/**
 * 存储分页查询时的参数
 */
//public class ListQueryParameterObject {
//
//    protected int maxResults = Integer.MAX_VALUE;
//    /**
//     * 第一个结果的索引
//     */
//    protected int firstResult;
//    protected Object parameter;
//    protected String databaseType;
//
//    public ListQueryParameterObject() {
//    }
//
//    public ListQueryParameterObject(Object parameter, int firstResult, int maxResults) {
//        this.parameter = parameter;
//        this.firstResult = firstResult;
//        this.maxResults = maxResults;
//    }
//
//    public int getFirstResult() {
//        return firstResult;
//    }
//
//    public int getFirstRow() {
//        return firstResult + 1;
//    }
//
//    public int getLastRow() {
//        if (maxResults == Integer.MAX_VALUE) {
//            return maxResults;
//        }
//        return firstResult + maxResults + 1;
//    }
//
//    public int getMaxResults() {
//        return maxResults;
//    }
//
//    public Object getParameter() {
//        return parameter;
//    }
//
//    public void setFirstResult(int firstResult) {
//        this.firstResult = firstResult;
//    }
//
//    public void setMaxResults(int maxResults) {
//        this.maxResults = maxResults;
//    }
//
//    public void setParameter(Object parameter) {
//        this.parameter = parameter;
//    }
//
//    public String getOrderBy() {
//        // the default order column
//        return "RES.ID_ asc";
//    }
//
//    public String getOrderByColumns() {
//        return getOrderBy();
//    }
//
//    public void setDatabaseType(String databaseType) {
//        this.databaseType = databaseType;
//    }
//
//    public String getDatabaseType() {
//        return databaseType;
//    }
//
//}
