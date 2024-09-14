package com.guoleilei.activiti.engine.impl.variable;

import com.guoleilei.activiti.engine.ActivitiException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类的typeList里存的是所有的变量类型
 */
public class DefaultVariableTypes implements VariableTypes, Serializable {

    private static final long serialVersionUID = 1L;

    private final List<VariableType> typesList = new ArrayList<VariableType>();
    private final Map<String, VariableType> typesMap = new HashMap<String, VariableType>();



    public VariableType findVariableType(Object value) {
        for (VariableType type : typesList) {
            if (type.isAbleToStore(value)) {
                return type;
            }
        }
        throw new ActivitiException("couldn't find a variable type that is able to serialize " + value);
    }
}
