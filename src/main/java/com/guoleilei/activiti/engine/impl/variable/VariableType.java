package com.guoleilei.activiti.engine.impl.variable;

public interface VariableType {

    /**
     * name of variable type (limited to 100 characters length)
     */
    public String getTypeName();

//    /**
//     * <p>
//     * Indicates if this variable type supports caching.
//     * </p>
//     * <p>
//     * If caching is supported, the result of {@link #getValue(ValueFields)} is saved for the duration of the session and used for subsequent reads of the variable's value.
//     * </p>
//     * <p>
//     * If caching is not supported, all reads of a variable's value require a fresh call to {@link #getValue(ValueFields)}.
//     * </p>
//     *
//     * @return whether variables of this type are cacheable.
//     */
    boolean isCachable();

    /**
     * @return whether this variable type can store the specified value.
     */
    boolean isAbleToStore(Object value);

//    /**
//     * Stores the specified value in the supplied {@link ValueFields}.
//     */
//    void setValue(Object value, ValueFields valueFields);
//
//    /**
//     * @return the value of a variable based on the specified {@link ValueFields}.
//     */
//    Object getValue(ValueFields valueFields);

}
