package com.tmonitor.find.core.serializer;

/**
 * 序列化异常
 * @author qrz
 * @date 2020/12/26
 * @since 1.0.0
 */
public class SerializerException extends RuntimeException {
    public SerializerException() {
        super();
    }

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializerException(Throwable cause) {
        super(cause);
    }

    protected SerializerException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}