package com.guoleilei.activiti.engine.impl.interceptor;

/**
 * A session factory produces a {@link Session} instance that has the lifespane of one {@link Command}.
 *
 */
public interface SessionFactory {

    Class<?> getSessionType();

    Session openSession(CommandContext commandContext);

}
