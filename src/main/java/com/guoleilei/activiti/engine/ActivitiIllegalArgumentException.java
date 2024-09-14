package com.guoleilei.activiti.engine;


/**
 * An exception indicating that an illegal argument has been supplied in an Activiti API-call, an illegal value was configured in the engine's configuration or an illegal value has been supplied or an
 * illegal value is used in a process-definition.
 *

 */
public class ActivitiIllegalArgumentException extends ActivitiException {

    private static final long serialVersionUID = 1L;

    public ActivitiIllegalArgumentException(String message) {
        super(message);
    }

    public ActivitiIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
