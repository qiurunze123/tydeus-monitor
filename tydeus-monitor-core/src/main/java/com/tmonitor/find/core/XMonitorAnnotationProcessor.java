package com.tmonitor.find.core;

import com.tmonitor.find.core.event.EventGenerator;
import com.tmonitor.find.core.serializer.Serializer;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author：qrz
 * @Date：2025/4/4 15:43
 * @Description Xmonitor annotation 处理器
 */
public class XMonitorAnnotationProcessor implements MethodInterceptor, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private Logger log = LoggerFactory.getLogger(XMonitorAnnotationProcessor.class);


    /**
     * 默认请求参数（ request ） Serializer
     */
    private Serializer defaultRequestSerializer;

    /**
     * 默认 响应结果（response）Serializer
     */
    private Serializer defaultResponseSerializer;


    /**
     * 默认 EventGenerator
     */
    private EventGenerator defaultEventGenerator;


    /**
     * void 返回值类型
     */
    protected static final String RETURN_TYPE_VOID = "void";

    /**
     * 空字符串
     */
    protected static final String EMPTY_STRING = "";

    /**
     * Spring ApplicationContext
     */
    private ApplicationContext applicationContext;

    private Map<String, Serializer> serializerMap = new ConcurrentHashMap<>();


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    /**
     * 序列化 请求参数
     *
     * @param annotation
     * @param arguments
     * @return 返回序列化之后的字符串
     */
    protected String serializeRequest(TMonitor annotation, Object[] arguments) {
        if (!annotation.logRequestOnStat()) {
            return EMPTY_STRING;
        }

        Serializer serializer;
        serializer = getSerializer(annotation.requestSerializer(), this.defaultRequestSerializer);
        return doSerialize(serializer, arguments, null);
    }

    protected Serializer getSerializer(String name, Serializer defaultSerializer) {
        return this.serializerMap.getOrDefault(name, defaultSerializer);
    }


    /**
     * 执行 序列化
     *
     * <p>序列化失败，不影响主流程</p>
     *
     * @param serializer 序列化 Serializer
     * @param object     待序列化的 目标对象
     * @param expression 待序列化的 目标对象 数据提取 表达式
     * @return 返回 序列化后的 String；如序列化失败，则返回异常类型及异常Message
     */
    protected String doSerialize(Serializer serializer, Object object, String expression) {
        try {
            return serializer.serialize(object);
        } catch (Throwable e) {
            log.warn("Serialize.Exception, [serializer={}, object={}]",
                    serializer.getClass().getSimpleName(), object, e
            );
            // 序列化失败，则返回异常类型及异常Message
            return String.format("TMonitor.%s.Exception:%s", e.getClass().getSimpleName(), e.getMessage());
        }
    }

}
