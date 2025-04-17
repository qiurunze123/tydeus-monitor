package com.tmonitor.find.core.serializer.support;

import com.tmonitor.find.core.serializer.Serializer;
import com.tmonitor.find.core.serializer.SerializerException;

import java.io.Serializable;

/**
 * @Author：qrz
 * @Date：2025/4/3 19:51
 * @Description
 */
public class NoneSerializer<T> implements Serializer<T> {
    protected static final String EMPTY_STRING = "";

    @Override
    public String serialize(T object) throws SerializerException {
        return EMPTY_STRING;
    }
}
