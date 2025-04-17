package com.tmonitor.find.core.serializer;

/**
 * @Author：qrz
 * @Date：2025/3/30 19:12
 * @Filename：Serializer
 * @Description 序列化器 - 接口类 Serializer
 */
public interface Serializer<T> {


    /**
     *  serialize java object to string
     * @param object java object
     * @return 序列化类
     * @throws SerializerException  序列化失败抛出序列化异常
     */
    String serialize(T object) throws SerializerException ;
}
