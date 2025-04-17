package com.tmonitor.find.core.serializer.support;

import com.tmonitor.find.core.serializer.Serializer;
import com.tmonitor.find.core.serializer.SerializerException;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author：qrz
 * @Date：2025/4/3 19:54
 * @Description
 */
public class ToStringSerializer<T> implements Serializer<T> {

    public static final String NULL = "null" ;
    @Override
    public String serialize(T object) throws SerializerException {

        if(Objects.isNull(object)){
            return NULL;
        }

        //数组类型
        if(object.getClass().isArray()){
            return Arrays.toString((Object[]) object);
        }

        return Objects.toString(object,NULL);
    }
}
