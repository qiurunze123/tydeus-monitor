package com.tmonitor.find.core.event;

import com.tmonitor.find.core.context.Context;

/**
 * @Author：qrz
 * @Date：2025/4/3 20:48
 * @Description 监控事件生成器
 */
public interface EventGenerator {

    /**
     * 生成 监控事件
     * @param context 监控上下文
     * @return 返回一个非 null 的event
     */
    Event generate(Context context);
}
