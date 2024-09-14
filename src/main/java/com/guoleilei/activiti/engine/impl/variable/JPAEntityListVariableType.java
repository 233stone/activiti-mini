package com.guoleilei.activiti.engine.impl.variable;

/**
 * Variable type capable of storing a list of reference to JPA-entities. Only JPA-Entities which are configured by annotations are supported. Use of compound primary keys is not supported. <br>
 * The variable value should be of type {@link List} and can only contain objects of the same type.
 */
public class JPAEntityListVariableType implements VariableType {

    public static final String TYPE_NAME = "jpa-entity-list";

//    protected JPAEntityMappings mappings;

    protected boolean forceCachedValue;

    public JPAEntityListVariableType() {
//        mappings = new JPAEntityMappings();
    }


    @Override
    public String getTypeName() {
        return "";
    }

    @Override
    public boolean isCachable() {
        return false;
    }

    @Override
    public boolean isAbleToStore(Object value) {
        return false;
    }
}
