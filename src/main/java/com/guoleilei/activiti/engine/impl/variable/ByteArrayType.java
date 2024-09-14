package com.guoleilei.activiti.engine.impl.variable;

public class ByteArrayType implements VariableType {

    private static final long serialVersionUID = 1L;

    public String getTypeName() {
        return "bytes";
    }

    public boolean isCachable() {
        return true;
    }

//    public Object getValue(ValueFields valueFields) {
//        return valueFields.getBytes();
//    }
//
//    public void setValue(Object value, ValueFields valueFields) {
//        valueFields.setBytes((byte[]) value);
//    }

    public boolean isAbleToStore(Object value) {
        if (value == null) {
            return true;
        }
        return byte[].class.isAssignableFrom(value.getClass());
    }
}
