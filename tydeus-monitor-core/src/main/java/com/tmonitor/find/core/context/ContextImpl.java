package com.tmonitor.find.core.context;

import java.lang.reflect.Method;

/**
 * @Author：qrz
 * @Date：2025/4/3 20:06
 * @Description  context 实现类
 */
public class ContextImpl implements Context {

    /**
     * 监控代码
     */
    private  String code;

    /**
     * 监控 目标对象
     */
    private Object target;

    /**
     * 监控 目标对象方法
     */
    private Method method;

    /**
     * 监控 目标对象 方法请求参数
     */
    private Object[] arguments;

    /**
     * 监控 目标对象 方法 返回值
     */
    private Object response;

    /**
     * 监控 目标对象 方法 执行异常
     */
    private Throwable throwable;

    /**
     * 监控 目标方法 方法 执行耗时 毫秒数
     */
    private long methodCost;


    public ContextImpl setCode(String code) {
        this.code = code;
        return this;
    }

    public ContextImpl setTarget(Object target) {
        this.target = target;
        return this;
    }

    public ContextImpl setMethod(Method method) {
        this.method = method;
        return this;
    }

    public ContextImpl setArguments(Object[] arguments) {
        this.arguments = arguments;
        return this;
    }

    public ContextImpl setResponse(Object response) {
        this.response = response;
        return this;
    }

    public ContextImpl setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    public ContextImpl setMethodCost(long methodCost) {
        this.methodCost = methodCost;
        return this;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object getResponse() {
        return response;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public long getMethodCost() {
        return methodCost;
    }
}
