package com.guoleilei.activiti.engine.impl.variable;

/**
 * Variable type capable of storing reference to JPA-entities. Only JPA-Entities which are configured by annotations are supported. Use of compound primary keys is not supported.
 *

 */
public class JPAEntityVariableType implements VariableType {

    public static final String TYPE_NAME = "jpa-entity";

//    private JPAEntityMappings mappings;

    private boolean forceCacheable;


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
