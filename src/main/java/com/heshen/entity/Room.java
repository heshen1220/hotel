package com.heshen.entity;

import lombok.Data;

@Data
public class Room {
    private Integer uuid;
    private Integer number;
    private Integer area;
    private String type;
    private Integer people;
    private String state;
    private Integer price;
    private String memo;
}
