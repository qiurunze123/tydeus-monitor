package com.tmonitor.find.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.tmonitor.find.core.constant.TydeusLogConstants.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TMonitor {

    /**
     * 监控代码自定义区域
     * @return
     */
    String code() default "" ;

    /**
     * 监控描述
     * @return
     */
    String desc() default "";
    /**
     * 记录（成功、失败、异常）是否也记录请求参数
     * @return
     */
    boolean logRequestOnStat() default false;

    /**
     * 记录（成功、失败、异常）是否也记录响应结果
     * @return
     */
    boolean logResponseOnStat() default false;

    /**
     * 请求参数 序列化器 bean name
     * @return spring bean name of request {@link com.tmonitor.find.core.serializer.Serializer}
     */
    String requestSerializer() default DEFAULT_REQUEST_SERIALIZER ;

    /**
     * 响应结果 序列化器 bean name
     * @return spring bean name of response {@link com.tmonitor.find.core.serializer.Serializer}
     */
    String responseSerializer() default DEFAULT_RESPONSE_SERIALIZER;

    /**
     * 监控事件生成器 bean name
     * @return spring bean name of {@link com.tmonitor.find.core.event.EventGenerator}
     */
    String eventGenerator() default DEFAULT_EVENT_GENERATOR;


}
