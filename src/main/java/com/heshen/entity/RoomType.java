package com.heshen.entity;

import lombok.Data;

@Data
public class RoomType {
    private String type;
    private Integer area;
    private Integer people;
    private Integer num;
    private Integer price;
    private String memo;
}
