package com.tmonitor.find.core.serializer.support;

import com.alibaba.fastjson.JSON;
import com.tmonitor.find.core.serializer.Serializer;
import com.tmonitor.find.core.serializer.SerializerException;

/**
 * @Author：qrz
 * @Date：2025/3/30 19:22
 * @Description JSON 序列化
 */
public class JSONSerializer<T> implements Serializer<T> {
    @Override
    public String serialize(T object) throws SerializerException {
        return JSON.toJSONString(object);
    }
}
