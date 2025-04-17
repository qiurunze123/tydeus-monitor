package com.tmonitor.find.core.event.support;

import com.tmonitor.find.core.context.Context;
import com.tmonitor.find.core.event.Event;
import com.tmonitor.find.core.event.EventGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author：qrz
 * @Date：2025/4/3 20:52
 * @Description 默认eventgenerator
 * <p> 无异常 则返回{@link Event#SUCCESS}</>
 * <p> 有异常 则返回{@link Event#EXCEPTION}</>
 */
public class DefaultEventGenerator  implements EventGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultEventGenerator.class);

    /**
     * ErrorInfo 提取器 列表
     *
     * @since 1.0.10
     */
    private List<ReturnObjectEventGenerator> returnObjectEventGenerators = new ArrayList<>();


    public DefaultEventGenerator(){

    }

    /**
     * 支持自定义 ReturnObjectEventGenerator
     * @param returnObjectEventGenerators 列表
     */
    public DefaultEventGenerator(List<ReturnObjectEventGenerator> returnObjectEventGenerators){
        if(Objects.nonNull(returnObjectEventGenerators) && !returnObjectEventGenerators.isEmpty()){
            this.returnObjectEventGenerators.addAll(returnObjectEventGenerators.stream()
                    .sorted(Comparator.comparing(ReturnObjectEventGenerator::getOrder))
                    .collect(Collectors.toList()));
        };
        this.returnObjectEventGenerators.forEach(generator->{
            LOGGER.info("add:{} , order:{}" , generator.getClass(),generator.getOrder());
        });
    }


    @Override
    public Event generate(Context context) {
       Throwable throwable = context.getThrowable();
       Event event =null;

       if(Objects.nonNull(throwable)){
           event = Event.EXCEPTION;
           //有配置映射 按顺序提取
       }else if(!returnObjectEventGenerators.isEmpty()){
           Class<?> returnType = context.getMethod().getReturnType();
           Object returnObject = context.getResponse();


           for(ReturnObjectEventGenerator generator:returnObjectEventGenerators){
               try {
                   if (generator.accept(returnType)) {
                       event = generator.generate(returnObject);
                       break;
                   }
               }catch (Exception ex){
                   LOGGER.warn("failed to genrate xmonitor event by {}",generator,ex);
                   return Event.UNKNOWN;
               }
           }
       }
       return Objects.nonNull(event)?event:Event.SUCCESS;
    }
}
