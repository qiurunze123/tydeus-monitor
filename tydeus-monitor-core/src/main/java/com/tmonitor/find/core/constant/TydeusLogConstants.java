package com.tmonitor.find.core.constant;

/**
 * tydeus  monitor  bean命名注册器
 */
public class TydeusLogConstants {

    /**
     * 防止注册重名 给一个后缀注册器
     */
    public static final String BEAN_NAME_SUFFIX = "#TMonitor";

    /**
     * =============== XMonitor 扩展接口 默认实现类的  spring bean name  =============
     */
    /**
     * 记录请求参数默认序列化器
     */
    public static final String DEFAULT_REQUEST_SERIALIZER = "defaultRequestSerializer" + BEAN_NAME_SUFFIX;

    public static final String DEFAULT_RESPONSE_SERIALIZER = "defaultResponseSerializer" + BEAN_NAME_SUFFIX;

    public static final String DEFAULT_EVENT_GENERATOR = "defaultEventGenerator" + BEAN_NAME_SUFFIX;

    /**
     * ============== TMonitor 内置的Serializer Spring bean name =================
     */

    public static final String GENERAL_SERIALIZER = "generalSerializer"+BEAN_NAME_SUFFIX;

}
