package com.tmonitor.find.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author：qrz
 * @Date：2025/3/30 19:32
 * @Description TMonitor 注册类 注册需要的bean
 * @EnableAspectJAutoProxy(exposeProxy = true) 将spring aop代理暴漏出来
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ConditionalOnProperty(prefix = "tmonitor.auto" , name = "enabled" , havingValue = "true" , matchIfMissing = true)
public class TMonitorAutoConfiguration {
}
