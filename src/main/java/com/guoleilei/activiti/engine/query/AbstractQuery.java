package com.guoleilei.activiti.engine.query;

import com.guoleilei.activiti.engine.ActivitiException;
import com.guoleilei.activiti.engine.ActivitiIllegalArgumentException;
import com.guoleilei.activiti.engine.impl.Direction;
import com.guoleilei.activiti.engine.impl.context.Context;
import com.guoleilei.activiti.engine.impl.interceptor.Command;
import com.guoleilei.activiti.engine.impl.interceptor.CommandContext;
import com.guoleilei.activiti.engine.impl.interceptor.CommandExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * 所有查询类的 抽象 超类
 *
 * 这个类主要就是实现Query接口的方法，
 * 最后返回结果的操作都交给{@link CommandExecutor}执行或者{@link Command#execute(CommandContext)}执行
 * {@link AbstractQuery#count()} 和{@link AbstractQuery#list()}都用到了 模板方法模式，方法中定义了基本的执行逻辑，具体某一步骤的实现交给子类
 */
public abstract class AbstractQuery<T extends Query<?, ?>, U> implements Command<Object>, Query<T, U>, Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SORTORDER_ASC = "asc";
    public static final String SORTORDER_DESC = "desc";

    private static enum ResultType {
        LIST, SINGLE_RESULT, COUNT
    }

    protected transient CommandExecutor commandExecutor;
    protected transient CommandContext commandContext;

    protected String orderBy;

    protected ResultType resultType;

    protected QueryProperty orderProperty;


    // 构造方法

    protected AbstractQuery() {
//        parameter = this;
    }

    protected AbstractQuery(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public AbstractQuery(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    // 实现Query的方法

    @Override
    @SuppressWarnings("unchecked")
    public T orderBy(QueryProperty property) {
        this.orderProperty = property;
        return (T) this;
    }

    @Override
    public T asc() {
        return direction(Direction.ASCENDING);
    }

    @Override
    public T desc() {
        return direction(Direction.DESCENDING);
    }

    @SuppressWarnings("unchecked")
    @Override
    public U singleResult() {
        this.resultType = ResultType.SINGLE_RESULT;
        if (commandExecutor != null) {
            return (U) commandExecutor.execute(this);
        }
        return executeSingleResult(Context.getCommandContext());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<U> list() {
        this.resultType = ResultType.LIST;
        if (commandExecutor != null) {
            return (List<U>) commandExecutor.execute(this);
        }
        return executeList(Context.getCommandContext());
    }


    @Override
    public long count() {
        this.resultType = ResultType.COUNT;
        if (commandExecutor != null) {
            return (Long) commandExecutor.execute(this);
        }
        return executeCount(Context.getCommandContext());
    }


    // 实现 {@link Command} 的方法
    @Override
    public Object execute(CommandContext commandContext) {
        if (resultType == ResultType.LIST) {
            return executeList(commandContext);
        } else if (resultType == ResultType.SINGLE_RESULT) {
            return executeSingleResult(commandContext);
        } else {
            return executeCount(commandContext);
        }
    }

    public U executeSingleResult(CommandContext commandContext) {
        List<U> results = executeList(commandContext);
        if (results.size() == 1) {
            return results.get(0);
        } else if (results.size() > 1) {
            throw new ActivitiException("Query return " + results.size() + " results instead of max 1");
        }
        return null;
    }

    public abstract List<U> executeList(CommandContext commandContext);

    public abstract long executeCount(CommandContext commandContext);


    @SuppressWarnings("unchecked")
    public T direction(Direction direction) {
        if (orderProperty == null) {
            throw new ActivitiIllegalArgumentException("You should call any of the orderBy methods first before specifying a direction");
        }
        addOrder(orderProperty.getName(), direction.getName());
        orderProperty = null;
        return (T) this;
    }

    protected void addOrder(String column, String sortOrder) {
        if (orderBy == null) {
            orderBy = "";
        } else {
            orderBy = orderBy + ", ";
        }

        String defaultOrderByClause = column + " " + sortOrder;
        orderBy = orderBy + defaultOrderByClause;
    }

    /**
     * 这个方法只会在返回结果时被调用
     * 判断有没有在{@link AbstractQuery#orderBy(QueryProperty)}之后调用{@link AbstractQuery#desc()}或者{@link AbstractQuery#asc()}
     */
    protected void checkQueryOk() {
        if (orderProperty != null) {
            throw new ActivitiIllegalArgumentException("Invalid query: call asc() or desc() after using orderByXX()");
        }
    }

}
