package com.tmonitor.find.core.context;

import java.lang.reflect.Method;

/**
 * @Author：qrz
 * @Date：2025/4/3 19:58
 * @Description 监控处理上下文
 */
public interface Context {


    /**
     * 获取监控代码
     * @return 监控代码
     */
    String getCode();


    /**
     * 获取监控目标对象
     * @return 监控目标对象
     */
    Object getTarget();

    /**
     * 获取监控 目标方法
     * @return 目标方法对象
     */
    Method getMethod();

    /**
     * 获取监控 目标对象 方法请求参数
     * @return 监控 目标对象 方法请求参数
     */
    Object[] getArguments();


    /**
     * 获取 目标对象 方法返回值
     * @return 目标对象 方法返回值
     */
    Object getResponse();

    /**
     * 获取监控目标对象 方法 执行异常
     * @return
     */
    Throwable getThrowable();

    /**
     * 获取监控 目标对象方法 执行耗时 毫秒数
     * @return 目标对象方法 执行耗时 毫秒数
     */
    long getMethodCost();

}
