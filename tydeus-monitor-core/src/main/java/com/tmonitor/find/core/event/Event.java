package com.tmonitor.find.core.event;

/**
 * @Author：qrz
 * @Date：2025/4/3 20:20
 * @Description
 */
public enum Event {

    SUCCESS("S","执行成功"),
    FAILED("F","执行失败"),
    EXCEPTION("E","执行异常"),
    UNKNOWN("X","未知");

    Event(String code , String desc){
        this.code = code;
        this.desc = desc ;
    }

    private String code ;
    private String desc ;

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
