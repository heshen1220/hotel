package com.heshen.entity;

import lombok.Data;

@Data
public class Reception{
    private String uuid;
    private String name;
    private String phone;
    private String certificates="居民身份证";
    private String id;
    private String room;
    private String deposit;
    private String time;
    private String timeIn;
    private String timeOut;
    private String memo;
}
