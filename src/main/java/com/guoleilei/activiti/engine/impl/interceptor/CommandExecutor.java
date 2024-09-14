package com.guoleilei.activiti.engine.impl.interceptor;

/**
 * The command executor for internal usage.
 *

 */
public interface CommandExecutor {

//    /**
//     * @return the default {@link CommandConfig}, used if none is provided.
//     */
//    CommandConfig getDefaultConfig();
//
//    /**
//     * Execute a command with the specified {@link CommandConfig}.
//     */
//    <T> T execute(CommandConfig config, Command<T> command);
//
//    /**
//     * 使用默认命令配置 {@link CommandConfig} 执行一个命令
//     */
    <T> T execute(Command<T> command);

}
