package com.tmonitor.find.core.event.support;

import com.tmonitor.find.core.event.Event;
import org.springframework.core.Ordered;

/**
 * @Author：qrz
 * @Date：2025/4/3 20:59
 * @Description 基于 监控的目标方法 返回值对象 生成监控时间的时间生成器
 */
public interface ReturnObjectEventGenerator<T> extends Ordered {


    /**
     * 排序值 数值越小 优先级越高 默认最低优先级
     * @return
     */
    default int getOrder(){
        return Ordered.LOWEST_PRECEDENCE;
    }


    /**
     * 首付支持 指定的 方法返回对象 类型
     * @param returnObjectType 方法返回值对象 类类型
     * @return true 支持  false 不支持
     */
    boolean accept(Class<T> returnObjectType) ;

    /**
     * 根据监控目标方法 返回值对象 生成监控事件
     * @param returnObject 方法返回值对象
     * @return ErrorInfo
     */
    Event generate(T  returnObject);
}
