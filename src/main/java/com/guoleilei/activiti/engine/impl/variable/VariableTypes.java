package com.guoleilei.activiti.engine.impl.variable;

import com.guoleilei.activiti.engine.ActivitiException;

/**
 * Interface describing a container for all available {@link VariableType}s of variables.
 *


 */
public interface VariableTypes {
//
//    /**
//     * @return the type for the given type name. Returns null if no type was found with the name.
//     */
//    public VariableType getVariableType(String typeName);
//
//    /**
//     * @return the variable type to be used to store the given value as a variable.
//     * @throws ActivitiException
//     *           When no available type is capable of storing the value.
//     */
    public VariableType findVariableType(Object value);
//
//    public VariableTypes addType(VariableType type);
//
//    /**
//     * Add type at the given index. The index is used when finding a type for an object. When different types can store a specific object value, the one with the smallest index will be used.
//     */
//    public VariableTypes addType(VariableType type, int index);
//
//    public int getTypeIndex(VariableType type);
//
//    public int getTypeIndex(String typeName);
//
//    public VariableTypes removeType(VariableType type);
}
