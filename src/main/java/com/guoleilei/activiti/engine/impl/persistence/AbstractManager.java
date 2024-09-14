package com.guoleilei.activiti.engine.impl.persistence;

import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.context.Context;
import com.guoleilei.activiti.engine.impl.interceptor.CommandContext;

public abstract class AbstractManager {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;

    public AbstractManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
        this.processEngineConfiguration = processEngineConfiguration;
    }

    // Command scoped

    protected CommandContext getCommandContext() {
        return Context.getCommandContext();
    }

    protected <T> T getSession(Class<T> sessionClass) {
        return getCommandContext().getSession(sessionClass);
    }

    // Engine scoped

    protected ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }

}
