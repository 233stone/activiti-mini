package com.guoleilei.activiti.engine.impl.interceptor;

import com.guoleilei.activiti.engine.ActivitiException;
import com.guoleilei.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import com.guoleilei.activiti.engine.impl.persistence.entity.TaskEntityManager;
import com.guoleilei.activiti.engine.impl.persistence.entity.VariableInstanceEntityManager;

import java.util.HashMap;
import java.util.Map;

public class CommandContext {

    protected Map<Class<?>, Session> sessions = new HashMap<>();

    protected Map<Class<?>, SessionFactory> sessionFactories;


    protected ProcessEngineConfigurationImpl processEngineConfiguration;


    public TaskEntityManager getTaskEntityManager() {
        return processEngineConfiguration.getTaskEntityManager();
    }

    public VariableInstanceEntityManager getVariableInstanceEntityManager() {
        return processEngineConfiguration.getVariableInstanceEntityManager();
    }

    @SuppressWarnings({"unchecked"})
    public <T> T getSession(Class<T> sessionClass) {
        Session session = sessions.get(sessionClass);
        if (session == null) {
            SessionFactory sessionFactory = sessionFactories.get(sessionClass);
            if (sessionFactory == null) {
                throw new ActivitiException("no session factory configured for " + sessionClass.getName());
            }
            session = sessionFactory.openSession(this);
            sessions.put(sessionClass,
                    session);
        }

        return (T) session;
    }
}
